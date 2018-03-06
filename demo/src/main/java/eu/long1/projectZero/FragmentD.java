/*
 * Copyright (c) 2016 Lung Razvan
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package eu.long1.projectZero;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Arrays;

import de.mrapp.android.dialog.MaterialDialog;
import de.mrapp.android.dialog.ProgressDialog;


public class FragmentD extends Fragment {

    private View view;
    GridView grid;
    String[] list = {
            "下载数据",
            "上传记录",
            "退出登录",
            "清除缓存",
            "关于我们",
            "使用帮助",
            "版本管理"};

    int[] imageID = {
            R.drawable.img_download,
            R.drawable.img_upload,
            R.drawable.img_logout,
            R.drawable.img_clear_cache,
            R.drawable.img_about_us,
            R.drawable.img_help,
            R.drawable.img_version_control};

    MaterialDialog.Builder dialogBuilder;
    MaterialDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        setMenuVisibility(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("设置");
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_d, container, false);

        grid = (GridView) view.findViewById(R.id.grid);
        grid.setAdapter(new CustomGrid(getActivity(), list, imageID));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(Arrays.asList(list).get(position).equals("下载数据")) {
                    Toast.makeText(getActivity(),
                            Arrays.asList(list).get(position), Toast.LENGTH_SHORT).show();
                }

                if (Arrays.asList(list).get(position).equals("上传记录")) {
                    //material dialog
                    dialogBuilder = new MaterialDialog.Builder(getActivity());
                    dialogBuilder
                            .setTitle("注意！")
                            .setTitleColor(ContextCompat.getColor(getContext(), R.color.primary_dark))
                            .setMessage("上传后案件详情将会从手机中删除\n" +
                                    "请登录网站查看已上传的案件\n" +
                                    "www.****.cn")
                            .setButtonTextColor(ContextCompat.getColor(getContext(), R.color.tbgreen))
                            .setPositiveButton("确认", null)
                            .setNegativeButton("取消", null)
                            .setWidth(900)
                            .setHeight(650);
                    dialog = dialogBuilder.create();
                    dialog.show();

                    //上传数据 logic

                }
                if (Arrays.asList(list).get(position).equals("退出登录")) {
                    dialogBuilder = new MaterialDialog.Builder(getActivity());
                    dialogBuilder
                            .setTitle("注意！")
                            .setTitleColor(ContextCompat.getColor(getContext(), R.color.primary_dark))
                            .setMessage("确定退出吗？")
                            .setButtonTextColor(ContextCompat.getColor(getContext(), R.color.tbgreen))
                            .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(getContext(), MainActivity.class);
                                    startActivity(i);
                                }
                            })
                            .setNegativeButton("取消", null)
                            .setWidth(900)
                            .setHeight(650);
                    dialog = dialogBuilder.create();
                    dialog.show();
                }
                if(Arrays.asList(list).get(position).equals("清除缓存")) {
                     Toast.makeText(getActivity(),
                             Arrays.asList(list).get(position), Toast.LENGTH_SHORT).show();
                }
                if(Arrays.asList(list).get(position).equals("关于我们")) {
                    Toast.makeText(getActivity(),
                            Arrays.asList(list).get(position), Toast.LENGTH_SHORT).show();
                }
                if(Arrays.asList(list).get(position).equals("使用帮助")) {
                    Intent i = new Intent(getContext(), HelpActivity.class);
                    startActivity(i);
                }
                if(Arrays.asList(list).get(position).equals("版本管理")) {
                    Toast.makeText(getActivity(),
                            "Version Name: " + BuildConfig.VERSION_NAME, Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Add your menu entries here
//        inflater.inflate(R.menu.menu_update, menu);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("设置");
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onStart() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("设置");
        super.onStart();
    }

}
