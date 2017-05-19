package br.com.gunna.optimus_app.androidapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.google.gson.reflect.TypeToken;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.ganfra.materialspinner.MaterialSpinner;

/**
 * Created by Daniel on 19/05/17.
 */

public class FragmentProduzir extends Fragment implements Validator.ValidationListener {
    @BindView(R.id.spin_max)
    MaterialSpinner spinMax;
    @BindView(R.id.spin_produto)
    MaterialSpinner spinProdutoA;
    @BindView(R.id.spin_produto_b)
    MaterialSpinner spinProdutoB;
    @BindView(R.id.spin_qt)
    MaterialEditText spinQtA;
    @BindView(R.id.spin_qt_b)
    MaterialEditText spinQtB;
    List<Produto> produtos;
    private List<String> productsNames;
    private Validator validator;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = getActivity().getLayoutInflater().inflate(R.layout.frament_produzir,null,false);
        ButterKnife.bind(this,view);
        validator = new Validator(this);
        validator.setValidationListener(this);
        setupViews();
        return view;
    }

    private void setupViews() {
        setupSpinMax();
        setupSpinProduct();
    }

    private void setupSpinProduct() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, getProductsNames());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinProdutoA.setAdapter(adapter);
        spinProdutoB.setAdapter(adapter);
    }

    private void setupSpinMax() {
        String[] itens = {"Maximizar","Minimizar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, itens);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinMax.setAdapter(adapter);
    }

    public List<String> getProductsNames() {
        TypeToken<List<Produto>> t = new TypeToken<List<Produto>>(){};
        produtos = (List<Produto>) GsonUtils.getObjectFromString(Constants.PRODUTOS,t.getClass());
        if(produtos != null){
           for(Produto p : produtos){
               productsNames.add(p.getNomeProduto());
           }
        }
        return productsNames;
    }

    @OnClick(R.id.btn_otimizar)
    void otimize(){
        validator.validate();
    }

    @Override
    public void onValidationSucceeded() {
        if(spinProdutoA.getSelectedItem().toString().equals(spinProdutoB.getSelectedItem().toString())){
            spinProdutoA.setError("Você deve escolher produtos diferentes");
            return;
        }

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        shakeErrors(errors);
    }

    public  void shakeErrors(List<ValidationError> errors){
        for(ValidationError error : errors){
            if(error.getView() instanceof MaterialEditText){
                MaterialEditText editText = (MaterialEditText) error.getView();
                editText.setError(error.getFailedRules().get(0).getMessage(getContext()));
            }
        }
    }
}
