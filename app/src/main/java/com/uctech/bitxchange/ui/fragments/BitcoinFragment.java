package com.uctech.bitxchange.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uctech.bitxchange.R;
import com.uctech.bitxchange.services.ApiClient;
import com.uctech.bitxchange.Interfaces.ApiInterface;
import com.uctech.bitxchange.adapters.CurrencyAdapter;
import com.uctech.bitxchange.model.CoinResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by UcheAtSoftquest on 10/10/2017.
 */

public class BitcoinFragment extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CurrencyAdapter currencyAdapter;
    private CoinResult coinResult;
    private static final String TAG = "BitcoinFragment";
    // TODO: Rename parameter arguments, choose names that match
    private static final String TAB_TITLE = "tabTitle";
    private static final String TAB_INDEX = "tabIndex";

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    private String tabTitle;
    private String tabIndex;

    private OnFragmentInteractionListener mListener;

    public BitcoinFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param tabTitle Parameter 1.
     * @return A new instance of fragment BitcoinFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BitcoinFragment instantiate(String tabTitle) {
        BitcoinFragment fragment = new BitcoinFragment();
        Bundle args = new Bundle();
        args.putString(TAB_TITLE, tabTitle);
       // args.putInt(TAB_INDEX, tabIndex);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tabTitle = getArguments().getString(TAB_TITLE);
        }

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<CoinResult> coinResultCall = apiInterface.getExchangeRate();
        coinResultCall.enqueue(new Callback<CoinResult>() {
            @Override
            public void onResponse(Call<CoinResult> call, Response<CoinResult> response) {
                coinResult = response.body();
                if(coinResult != null) {
                    recyclerView.setAdapter(new CurrencyAdapter(coinResult.getBitCoin().getData(), getContext(),tabTitle));
                }
            }
            @Override
            public void onFailure(Call<CoinResult> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bitcoin, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.bitcoin_recyclerview);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
