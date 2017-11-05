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

public class EthereumFragment extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CurrencyAdapter currencyAdapter;

    private static final String TAG = "EthereumFragment";
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAB_TITLE = "TAB_TITLE";


    private String mTabTitle;
    private OnFragmentInteractionListener mListener;

    public EthereumFragment() {

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param tabTitle
     * @return A new instance of fragment EthereumFragment.
     */
    //TODO: Rename and change types and number of parameters
    public static EthereumFragment instantiate(String tabTitle) {
        EthereumFragment fragment = new EthereumFragment();
        Bundle args = new Bundle();
        args.putString(TAB_TITLE, tabTitle);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTabTitle = getArguments().getString(TAB_TITLE);
        }
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<CoinResult> coinResultCall = apiInterface.getExchangeRate();
        coinResultCall.enqueue(new Callback<CoinResult>() {
            @Override
            public void onResponse(Call<CoinResult> call, Response<CoinResult> response) {
                int statusCode = response.code();
                CoinResult coinResult = response.body();
                layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(new CurrencyAdapter(coinResult.getEthereum().getData(), getContext(),mTabTitle));

                /*List<Currency> bitCoin = coinResult.getBitCoin().getData();
                Log.i(TAG,"bitCoin: "+bitCoin);
                List<Currency>  etherurm = coinResult.getEthereum().getData();
                Log.i(TAG,"etherurm: "+ etherurm);*/
            }

            @Override
            public void onFailure(Call<CoinResult> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ethereum, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.etherum_recyclerview);
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