package id.ac.polinema.idealbodyweight.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import id.ac.polinema.idealbodyweight.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ResultFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ResultFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private String informaton;
    private String bmi;

    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        final TextView informationText = view.findViewById(R.id.info_txt);
        final TextView informationText1 = view.findViewById(R.id.info_txt1);

        String tag = null;
        Fragment f = null;
        String [] arr = {"boca","bmi_idx"};

        for (int i = 0 ;i<arr.length;i++){
            f = getFragmentManager().findFragmentByTag(arr[i].toString());
            if(f instanceof BMIFragments){
                tag = f.getTag().toString();
                informationText1.setText(bmi);
                informationText.setText(informaton);
            }
            else if(f instanceof BrocaIndexFragment){
                tag = f.getTag().toString();
                informationText.setText(informaton);
            }
        }

        Button tryAg = view.findViewById(R.id.try_again);
        final String finalTag = tag;
        tryAg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    mListener.onTryAgainButtonClicked(finalTag);
                }
            }
        });
        return view;
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
        void onTryAgainButtonClicked(String tag);
    }

    public  void setInformation (String info){
        this.informaton = info;
    }
    public  void setInformationBMI (String bmi ,String info){
        this.bmi = bmi;
        this.informaton = info;
    }
}