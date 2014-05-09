package com.fragments.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment
{
	final String TAG = "PlaceholderFragment";
	private String value = null;
	private  TextView textView;
    public FragmentB() 
    {
    }
    
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
	}
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_b, container, false);
        
        //בשביל הטקסט שיופיע לפי לחיצה ברשימה
        textView = (TextView)rootView.findViewById(R.id.fragmentBtextView);
        textView.setText(value);
        return rootView;
    }

    
    /// כל זה כדי לראות את מעגל חיי הפרגמנט
    
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d(TAG, "onActivityCreated");
	}

	

	@Override
	public void onDestroy() {
		
		super.onDestroy();
		Log.d(TAG, "onDestroy");

	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Log.d(TAG, "onDestroyView");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		Log.d(TAG, "onDetach");
		
	}

	public void setText(String value) {
		this.value = value;
		
	}

	public void changeText(String value) {
		this.value = value;
		 textView.setText(value);
		
	}
}