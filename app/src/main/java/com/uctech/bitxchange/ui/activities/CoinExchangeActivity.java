package com.uctech.bitxchange.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.uctech.bitxchange.R;
import com.uctech.bitxchange.model.CoinResult;
import com.uctech.bitxchange.model.Currency;

import java.math.BigDecimal;


public class CoinExchangeActivity extends AppCompatActivity {
    private Currency mCurrency;
    private Currency[] mCurrencies;
    private EditText mBaseAmountEditText;
    private EditText mBaseAmountEquiEditText;
    private Spinner mBaseCurrencySpinner;
    private Spinner mQuoteCurrencySpinner;
    private String mTabTitle;
    private Toolbar mToolbar;
    private int mQuoteCoinSelectedIndex;
    private ArrayAdapter<String> mCoinAdapter;
    private String[] digitalCurrencies = {"BTC", "ETH"};
    String codes[] = {"USD", "EUR", "NGN", "AUD", "BRL", "GBP", "CAD", "CLP", "CNY",
            "CZK", "HKD", "HUF", "INR", "IDR", "ILS", "JPY", "KRW", "MYR", "MXN", "NZD"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_exchange);
        mBaseAmountEditText = (EditText) findViewById(R.id.base_amount_text);
        mQuoteCurrencySpinner = (Spinner) findViewById(R.id.quote_currency_spinner);
        mBaseCurrencySpinner = (Spinner) findViewById(R.id.base_currency_spinner);
        mBaseAmountEquiEditText = (EditText) findViewById(R.id.quote_value_equivalent_text);
        mToolbar = (Toolbar) findViewById(R.id.toolbar1);
        mCurrency = (Currency) this.getIntent().getSerializableExtra("SELECTED_ITEM");
        mCurrencies = (Currency[]) this.getIntent().getSerializableExtra("ALL_ITEMS");
        mTabTitle = this.getIntent().getStringExtra("TAB_TITLE");
        mQuoteCoinSelectedIndex = this.getIntent().getIntExtra("SELECTED_ITEM_INDEX",0);
        mToolbar.setTitle(setToolBarTitle(mTabTitle, mCurrency.getCode()));
        mToolbar.setSubtitle(setToolBarSubTitle(mTabTitle, mCurrency.getExchangeRate().toString() , mCurrency.getCode()));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mCoinAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, digitalCurrencies);
        mBaseCurrencySpinner.setAdapter(mCoinAdapter);
        mBaseCurrencySpinner.setSelection(indexOf(mCoinAdapter,mTabTitle));

        ArrayAdapter<String> currencyCodeAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, codes);
        mQuoteCurrencySpinner.setAdapter(currencyCodeAdapter);

        mQuoteCurrencySpinner.setSelection(indexOf(currencyCodeAdapter,mCurrency.getCode()));
        mBaseCurrencySpinner.setEnabled(false);
        mBaseAmountEquiEditText.setEnabled(false);
        mQuoteCurrencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (Currency currency : mCurrencies) {
                    if (currency.getCode().equals(codes[i])) {
                        mCurrency =currency;
                        if(mBaseAmountEditText.getText().toString().trim().length() !=0) {
                            BigDecimal baseAmount = new BigDecimal(mBaseAmountEditText.getText().toString());
                            //convert base currency to local currency
                            mBaseAmountEquiEditText.setText(convert(baseAmount, mCurrency.getExchangeRate()).toString());
                        }
                        mToolbar.setTitle(setToolBarTitle(mTabTitle, currency.getCode()));
                        mToolbar.setSubtitle(setToolBarSubTitle(mTabTitle, currency.getExchangeRate().toString() , currency.getCode()));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mBaseAmountEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(mBaseAmountEditText.getText().toString().trim().length() !=0) {
                    BigDecimal baseAmount = new BigDecimal(mBaseAmountEditText.getText().toString());
                    //convert base currency to local currency
                    mBaseAmountEquiEditText.setText(convert(baseAmount, mCurrency.getExchangeRate()).toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    /**
     * return base currency name
     * @param name
     * @return
     */
    private String getTitle(String name){
        return (name.equals("BTC"))? "Bitcoin": "Ethereum";
    }


    private int indexOf(final Adapter adapter, Object value)
    {
        for (int index = 0, count = adapter.getCount(); index < count; ++index)
        {
            if (adapter.getItem(index).equals(value))
            {
                return index;
            }
        }
        return -1;
    }

    /**
     * set tool bar title
     * @param coinCode
     * @param currencyCode
     * @return
     */
    private String setToolBarTitle(String coinCode, String currencyCode){
        return getTitle(coinCode).concat(" / ").concat(currencyCode);
    }

    /**
     * set tool bar sub title
     * @param coinCode
     * @param exchangeRate
     * @param currencyCode
     * @return
     */
    private String setToolBarSubTitle(String coinCode,String exchangeRate, String currencyCode){
        return "1 ".concat(coinCode).concat(" = ").concat(exchangeRate).concat(" ").concat(currencyCode);
    }


    /**
     * convert base currency to local currency
     * @param baseCurrency
     * @param localCurrency
     * @return
     */
  private BigDecimal convert(BigDecimal baseCurrency, BigDecimal localCurrency){
            return baseCurrency.multiply(localCurrency);
  }
}
