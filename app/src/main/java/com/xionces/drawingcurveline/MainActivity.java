package com.xionces.drawingcurveline;

import android.content.DialogInterface;
import android.graphics.Path;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextInputEditText x1,y1,x2,y2,x3,y3,x4,y4;
    Curve curve;
    CoordinatorLayout main_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        main_layout = (CoordinatorLayout) findViewById(R.id.main_layout);
        curve = new Curve(MainActivity.this);
        curve.setTag("Curve");
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        curve.setLayoutParams(params);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_line) {
            makeDialog();
            return true;
        }
        if (id == R.id.action_quadratic) {
            makeDialog_quadratic();
            return true;
        }
        if (id == R.id.action_cubic) {
            makeDialog_cubic();
            return true;
        }
        if (id == R.id.clear) {
            if (main_layout.findViewWithTag("Curve") != null) main_layout.removeView(main_layout.findViewWithTag("Curve"));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void makeDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    if (main_layout.findViewWithTag("Curve") != null) main_layout.removeView(main_layout.findViewWithTag("Curve"));
                    Path path = new Path();
                    path.moveTo(Integer.parseInt(x1.getText().toString()),Integer.parseInt(y1.getText().toString()));
                    path.lineTo(Integer.parseInt(x2.getText().toString()), Integer.parseInt(y2.getText().toString()));
                    curve.init(path);
                    main_layout.addView(curve);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        final AlertDialog dialog = builder.create();
        LayoutInflater inflater = getLayoutInflater();
        final View dialogLayout = inflater.inflate(R.layout.dialog_layout_line, null);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface d) {
                x1 = (TextInputEditText) dialogLayout.findViewById(R.id.x1);
                y1 = (TextInputEditText) dialogLayout.findViewById(R.id.y1);
                x2 = (TextInputEditText) dialogLayout.findViewById(R.id.x2);
                y2 = (TextInputEditText) dialogLayout.findViewById(R.id.y2);

            }
        });



        dialog.setTitle(getResources().getString(R.string.points));
        dialog.setView(dialogLayout);
        dialog.show();
    }



    private void makeDialog_quadratic()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    if (main_layout.findViewWithTag("Curve") != null) main_layout.removeView(main_layout.findViewWithTag("Curve"));
                    Path path = new Path();
                    path.moveTo(Integer.parseInt(x1.getText().toString()),Integer.parseInt(y1.getText().toString()));
                    path.quadTo(Integer.parseInt(x2.getText().toString()), Integer.parseInt(y2.getText().toString()), Integer.parseInt(x3.getText().toString()), Integer.parseInt(y3.getText().toString()));
                    curve.init(path);
                    main_layout.addView(curve);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        final AlertDialog dialog = builder.create();
        LayoutInflater inflater = getLayoutInflater();
        final View dialogLayout = inflater.inflate(R.layout.dialog_layout_quadratic, null);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface d) {
                x1 = (TextInputEditText) dialogLayout.findViewById(R.id.x1);
                y1 = (TextInputEditText) dialogLayout.findViewById(R.id.y1);
                x2 = (TextInputEditText) dialogLayout.findViewById(R.id.x2);
                y2 = (TextInputEditText) dialogLayout.findViewById(R.id.y2);
                x3 = (TextInputEditText) dialogLayout.findViewById(R.id.x3);
                y3 = (TextInputEditText) dialogLayout.findViewById(R.id.y3);
            }
        });



        dialog.setTitle(getResources().getString(R.string.points));
        dialog.setView(dialogLayout);
        dialog.show();
    }


    private void makeDialog_cubic()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    if (main_layout.findViewWithTag("Curve") != null) main_layout.removeView(main_layout.findViewWithTag("Curve"));
                    Path path = new Path();
                    path.moveTo(Integer.parseInt(x1.getText().toString()),Integer.parseInt(y1.getText().toString()));
                    path.cubicTo(Integer.parseInt(x2.getText().toString()), Integer.parseInt(y2.getText().toString()), Integer.parseInt(x3.getText().toString()), Integer.parseInt(y3.getText().toString()),
                            Integer.parseInt(x4.getText().toString()), Integer.parseInt(y4.getText().toString()));
                    curve.init(path);
                    main_layout.addView(curve);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        final AlertDialog dialog = builder.create();
        LayoutInflater inflater = getLayoutInflater();
        final View dialogLayout = inflater.inflate(R.layout.dialog_layout_cubic, null);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface d) {
                x1 = (TextInputEditText) dialogLayout.findViewById(R.id.x1);
                y1 = (TextInputEditText) dialogLayout.findViewById(R.id.y1);
                x2 = (TextInputEditText) dialogLayout.findViewById(R.id.x2);
                y2 = (TextInputEditText) dialogLayout.findViewById(R.id.y2);
                x3 = (TextInputEditText) dialogLayout.findViewById(R.id.x3);
                y3 = (TextInputEditText) dialogLayout.findViewById(R.id.y3);
                x4 = (TextInputEditText) dialogLayout.findViewById(R.id.x4);
                y4 = (TextInputEditText) dialogLayout.findViewById(R.id.y4);
            }
        });



        dialog.setTitle(getResources().getString(R.string.points));
        dialog.setView(dialogLayout);
        dialog.show();
    }


}
