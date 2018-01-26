package com.locensate.letnetwork.main.ui;


import android.Manifest;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.utils.ToastUtil;
import com.yalantis.ucrop.view.UCropView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.Calendar;
import java.util.List;

import static android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION;
import static android.content.Intent.FLAG_GRANT_WRITE_URI_PERMISSION;

/**
 *  
 * @author xiaobinghe
 */

public class ResultActivity extends BaseActivity {
    private static final String TAG = "ResultActivity";
    private static final int DOWNLOAD_NOTIFICATION_ID_DONE = 911;
    protected static final int REQUEST_STORAGE_READ_ACCESS_PERMISSION = 101;
    protected static final int REQUEST_STORAGE_WRITE_ACCESS_PERMISSION = 102;
    private AlertDialog mAlertDialog;

    public static void startWithUri(@NonNull Context context, @NonNull Uri uri) {
        Intent intent = new Intent(context, ResultActivity.class);
        intent.setData(uri);
        context.startActivity(intent);
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_result;
    }

    @Override
    public void initView() {
        try {
            UCropView uCropView = (UCropView) findViewById(R.id.ucrop);
            uCropView.getCropImageView().setImageUri(getIntent().getData(), null);
            uCropView.getOverlayView().setShowCropFrame(false);
            uCropView.getOverlayView().setShowCropGrid(false);
            uCropView.getOverlayView().setDimmedColor(Color.TRANSPARENT);
        } catch (Exception e) {
            Log.e(TAG, "setImageUri", e);
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(new File(getIntent().getData().getPath()).getAbsolutePath(), options);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getString(R.string.crop_result, options.outWidth, options.outHeight));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_download) {
            saveCroppedImage();
        } else if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_STORAGE_WRITE_ACCESS_PERMISSION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    saveCroppedImage();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void saveCroppedImage() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    "申请读写权限",
                    REQUEST_STORAGE_WRITE_ACCESS_PERMISSION);
        } else {
            Uri imageUri = getIntent().getData();
            if (imageUri != null && imageUri.getScheme().equals("file")) {
                try {
                    copyFileToDownloads(getIntent().getData());
                } catch (Exception e) {
                    Toast.makeText(ResultActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, imageUri.toString(), e);
                }
            } else {
                ToastUtil.show("");
            }
        }
    }


    protected void requestPermission(final String permission, String rationale, final int requestCode) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
            showAlertDialog(getString(R.string.permission_title_rationale), rationale,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(ResultActivity.this,
                                    new String[]{permission}, requestCode);
                        }
                    }, "确定", null, "取消");
        } else {
            ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
        }
    }


    protected void showAlertDialog(@Nullable String title, @Nullable String message,
                                   @Nullable DialogInterface.OnClickListener onPositiveButtonClickListener,
                                   @NonNull String positiveText,
                                   @Nullable DialogInterface.OnClickListener onNegativeButtonClickListener,
                                   @NonNull String negativeText) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positiveText, onPositiveButtonClickListener);
        builder.setNegativeButton(negativeText, onNegativeButtonClickListener);
        mAlertDialog = builder.show();
    }

    private void copyFileToDownloads(Uri croppedFileUri) throws Exception {
        String downloadsDirectoryPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        String filename = String.format("%d_%s", Calendar.getInstance().getTimeInMillis(), croppedFileUri.getLastPathSegment());

        File saveFile = new File(downloadsDirectoryPath, filename);

        FileInputStream inStream = new FileInputStream(new File(croppedFileUri.getPath()));
        FileOutputStream outStream = new FileOutputStream(saveFile);
        FileChannel inChannel = inStream.getChannel();
        FileChannel outChannel = outStream.getChannel();
        inChannel.transferTo(0, inChannel.size(), outChannel);
        inStream.close();
        outStream.close();

        showNotification(saveFile);
    }

    private void showNotification(@NonNull File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri fileUri = FileProvider.getUriForFile(
                this,
                "com.locensate.letnetwork",
                file);

        intent.setDataAndType(fileUri, "image/*");

        List<ResolveInfo> resInfoList = getPackageManager().queryIntentActivities(
                intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        for (ResolveInfo info : resInfoList) {
            grantUriPermission(
                    info.activityInfo.packageName,
                    fileUri, FLAG_GRANT_WRITE_URI_PERMISSION | FLAG_GRANT_READ_URI_PERMISSION);
        }

        NotificationCompat.Builder mNotification = new NotificationCompat.Builder(this);

        mNotification
                .setContentTitle(getString(R.string.app_name))
                .setContentText("图片保存，点击预览")
                .setTicker("保存图片")
                .setSmallIcon(R.drawable.ic_done)
                .setOngoing(false)
                .setContentIntent(PendingIntent.getActivity(this, 0, intent, 0))
                .setAutoCancel(true);
        ((NotificationManager) getSystemService(NOTIFICATION_SERVICE)).notify(DOWNLOAD_NOTIFICATION_ID_DONE, mNotification.build());
    }
}
