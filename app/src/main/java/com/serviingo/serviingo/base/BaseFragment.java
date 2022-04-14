package com.serviingo.serviingo.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * File Name: BaseFragment.java
 * Description: This file contains classes and functions for the Products Management.
 *
 * @author Devender
 * Date Created: 20/07/2021
 * Date Released:
 * Created by Devender Singh
 */
public class BaseFragment extends Fragment {
    protected Activity mActivity;
   // public static ArrayList<HashMap<String, String>> basearraylist = new ArrayList<>();
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mActivity = getActivity();
    }
}
