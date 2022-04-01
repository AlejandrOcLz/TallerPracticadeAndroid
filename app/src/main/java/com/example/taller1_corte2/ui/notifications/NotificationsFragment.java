package com.example.taller1_corte2.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.taller1_corte2.R;
import com.example.taller1_corte2.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    private WebView web;
   // WebView myWebView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        web = binding.web;
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("https://www.uceva.edu.co/");

      /*  myWebView = (WebView) findViewById(R.id.view);
        final WebSettings ajustesVisorWeb = myWebView.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://www.uceva.edu.co/");*/



       // final TextView textView = binding.textNotifications;
        //notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}