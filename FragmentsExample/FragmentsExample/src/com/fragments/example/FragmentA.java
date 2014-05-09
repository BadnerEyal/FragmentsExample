package com.fragments.example;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentA extends ListFragment
{
	final String TAG = "PlaceholderFragment";
	
	//רשימת הטלפונים
	final String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
	          "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
	          "Linux", "OS/2" };
	
    public FragmentA() 
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
      
     View view = super.onCreateView(inflater, container, savedInstanceState);

     //חיבור הרשימה לאטפאר	
      ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
          android.R.layout.simple_list_item_1, values);
      
      setListAdapter(adapter);
      
      return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
    	
    	//בזמן לחיצה על שורה נעביר לפי המיקום את הערך לפרגמנט השני להצגה
    	((SwitchFragmentsListener)getActivity()).switchAB(values[position]);
    }
    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        
    	View rootView = inflater.inflate(R.layout.fragment_a, container, false);
        
        Button switchButton = (Button)rootView.findViewById(R.id.switchButton);
        switchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				((SwitchFragmentsListener)getActivity()).switchAB();
				
			}
		});
        return rootView;
    }
    */

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
}