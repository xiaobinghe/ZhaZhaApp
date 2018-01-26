package com.locensate.letnetwork.main.ui.fragments.mine;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.ToastUtil;
import com.locensate.letnetwork.main.ui.AccountInfoActivity;
import com.locensate.letnetwork.main.ui.SettingActivity;
import com.locensate.letnetwork.view.CircleImageView;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.model.AspectRatio;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import static android.app.Activity.RESULT_OK;

/**
 *  
 * @author xiaobinghe
 */


public class MineFragment extends BaseFragment<MineFragmentPresenter, MineFragmentModel> implements MineFragmentConstract.View {


    private static final String TAG = "mineFragment";
    @BindView(R.id.iv_title_only_back)
    ImageView ivTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView tvTitleOnlyBack;
    @BindView(R.id.cv_head)
    CircleImageView cvHead;
    @BindView(R.id.iv_msg)
    ImageView ivMsg;
    @BindView(R.id.rl_account)
    RelativeLayout rlAccount;
    @BindView(R.id.iv_set)
    ImageView ivSet;
    @BindView(R.id.rl_setting)
    RelativeLayout rlSetting;
    private BottomSheetDialog bottomSheetDialog;
    private String picName = "head.jpg";
    private final String path = "let";
    private AlertDialog mAlertDialog;
    private int REQUEST_STORAGE_READ_ACCESS_PERMISSION = 0x101;
    private int REQUEST_SELECT_PICTURE = 0x102;
    private String CROPPED_IMAGE_NAME = "head.jpg";
    private int REQUEST_CAMERA_ = 0x104;
    private Uri cameraUri;
    private String mCacheFile;


    @Override
    public int getInflaterView() {
        return R.layout.fragment_mine;
    }


    @Override
    protected void initView() {
        tvTitleOnlyBack.setText("我的");
        ivTitleOnlyBack.setVisibility(View.INVISIBLE);
        Bitmap diskBitmap = getDiskBitmap(new File(getSDCardPath() + "/let", "head.jpg"));
        if (diskBitmap != null) {
            cvHead.setImageBitmap(diskBitmap);
        }
    }

    @Override
    protected void lazyLoad() {

    }


    @OnClick({R.id.cv_head, R.id.rl_account, R.id.rl_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cv_head:
                resetHeadImage();
                break;
            case R.id.rl_account:
                startActivity(new Intent(App.getApplication(), AccountInfoActivity.class));
                break;
            case R.id.rl_setting:
                startActivity(new Intent(App.getApplication(),SettingActivity.class));
                break;
        }
    }

    private void resetHeadImage() {
        bottomSheetDialog = new BottomSheetDialog(getActivity());
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.layout_bottom_take_photo, null);
        TextView takePhoto = (TextView) inflate.findViewById(R.id.tv_take_photo);
        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera();
                bottomSheetDialog.dismiss();
            }
        });
        TextView album = (TextView) inflate.findViewById(R.id.tv_photo_album);
        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickFromGallery();
                bottomSheetDialog.dismiss();
            }
        });
        TextView cancel = (TextView) inflate.findViewById(R.id.tv_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.show();
    }


    private void openCamera() {
        applyPermission();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        mCacheFile = format.format(date);
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        File outputImage = new File(path, mCacheFile + ".jpg");
        try {
            if (outputImage.exists()) {
                outputImage.delete();
            }
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cameraUri = Uri.fromFile(outputImage);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, cameraUri);
        intent.putExtra("noFaceDetection", true);
        startActivityForResult(intent, REQUEST_CAMERA_);
    }

    private void pickFromGallery() {
        applyPermission();
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(Intent.createChooser(intent, "选择图片"), REQUEST_SELECT_PICTURE);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e(TAG, "onActivityResult: +==========" + requestCode, null);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_SELECT_PICTURE) {
                final Uri selectedUri = data.getData();
                if (selectedUri != null) {
                    startCropActivity(data.getData());
                } else {
                    ToastUtil.show("无法检索选定的图像 ");
                }
            } else if (requestCode == UCrop.REQUEST_CROP) {
                LogUtil.e(TAG, "crop  return" + UCrop.getOutput(data).toString());
                handleCropResult(data);
            } else if (requestCode == REQUEST_CAMERA_) {
//                    fis = new FileInputStream(mFilePath); // 根据路径获取数据
//                    Bitmap bitmap = BitmapFactory.decodeStream(fis);
//                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                Intent intentBc = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                intentBc.setData(cameraUri);
                App.getApplication().sendBroadcast(intentBc);
                if (cameraUri != null) {
                    startCropActivity(cameraUri);
                }
            } else {
                displayImage(Environment.getExternalStorageDirectory() + "/let/head.jpg");
            }
        }
        if (resultCode == UCrop.RESULT_ERROR) {
            handleCropError(data);
        }
    }

    private void handleCropResult(Intent result) {
        final Uri data = UCrop.getOutput(result);
        LogUtil.e(TAG, "crop_result----" + data.toString());
        if (data != null) {
            File file = copyFileToDisk(data);
            displayImage(file.getPath());
            LogUtil.e(TAG, "file----" + file.getAbsolutePath());

            RequestBody uploadFile = RequestBody.create(MediaType.parse("*/*"), file);

//            mPresenter.mCompositeSubscription.add(Api.getInstance().service.upLoadAvatar(uploadFile).compose(RxSchedulers.<OnlyMsg>applyObservableAsync())
//
//                    .doOnNext(new Consumer<OnlyMsg>() {
//                        @Override
//                        public void accept(@io.reactivex.annotations.NonNull OnlyMsg onlyMsg) throws Exception {
//                            LogUtil.e(TAG, "onNext-----" + onlyMsg.getMsg() + "-----code---" + onlyMsg.getOperCode());
//                        }
//                    })
//                    .flatMap(new Function<OnlyMsg, ObservableSource<UserInfo>>() {
//                        @Override
//                        public ObservableSource<UserInfo> apply(@io.reactivex.annotations.NonNull OnlyMsg onlyMsg) throws Exception {
//                            LogUtil.e(TAG, "onNext-----" + onlyMsg.getMsg() + "-----code---" + onlyMsg.getOperCode());
//
//                            _User user = new Gson().fromJson(SpUtil.getString(App.getApplication(), Constant.USER, ""), _User.class);
//                            LogUtil.e(TAG, "user-----" + user.getData().getUserId() + "-----code---" + user.getData().getRealName() + "--organization--" + user.getData().getOrganization().getOrganizationName());
//
//
//                            UserInfo.DataBean info = new UserInfo.DataBean(onlyMsg.getMsg(), user.getData().getUserId());
//                            LogUtil.e(TAG, "gson---" + new Gson().toJson(info));
//                            return Api.getInstance().service.bindAvatar(user.getData().getUserId(), info).compose(RxSchedulers.<UserInfo>applyObservableAsync());
//                        }
//                    })
//                    .subscribe(new Consumer<UserInfo>() {
//                        @Override
//                        public void accept(@io.reactivex.annotations.NonNull UserInfo userInfo) throws Exception {
//                            LogUtil.e(TAG, "upload-----" + userInfo.getData().getUserAvatar());
//                        }
//                    }, new Consumer<Throwable>() {
//                        @Override
//                        public void accept(@io.reactivex.annotations.NonNull Throwable throwable) throws Exception {
//                            LogUtil.e(TAG, "error-----" + throwable.getMessage());
//
//                        }
//                    }));
        } else {
            ToastUtil.show("无法检索到图片");
        }
    }

    @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
    private void handleCropError(@NonNull Intent result) {
        final Throwable cropError = UCrop.getError(result);
        if (cropError != null) {
            Log.e(TAG, "handleCropError: ", cropError);
            ToastUtil.show(cropError.getMessage());
        } else {
            ToastUtil.show("无法检索裁剪图像");

        }
    }

    private void startCropActivity(@NonNull Uri uri) {
        String destinationFileName = CROPPED_IMAGE_NAME;
        UCrop uCrop = UCrop.of(uri, Uri.fromFile(new File(getContext().getCacheDir(), destinationFileName)));
        LogUtil.e(TAG, getContext().getCacheDir() + "/" + destinationFileName);
        uCrop = advancedConfig(uCrop);
        uCrop = uCrop.withAspectRatio(1.0f, 1.0f);
        uCrop.start(App.getApplication(), this);
    }

    /**
     * @param uCrop
     * @return
     */
    private UCrop advancedConfig(@NonNull UCrop uCrop) {
        UCrop.Options options = new UCrop.Options();

        options.setCompressionFormat(Bitmap.CompressFormat.JPEG);

        options.setHideBottomControls(true);
        options.setFreeStyleCropEnabled(false);

        /*
        If you want to configure how gestures work for all UCropActivity tabs

        options.setAllowedGestures(UCropActivity.SCALE, UCropActivity.ROTATE, UCropActivity.ALL);
        * */

       /* This sets max size for bitmap that will be decoded from source Uri.
        More size - more memory allocation, default implementation uses screen diagonal.
*/
        options.setMaxBitmapSize(240);


//        Tune everything (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧

        options.setMaxScaleMultiplier(5);
        options.setImageToCropBoundsAnimDuration(666);
        options.setDimmedLayerColor(Color.BLACK);
        options.setCircleDimmedLayer(false);
        options.setShowCropFrame(true);
        options.setCropGridColor(Color.TRANSPARENT);
        options.setCropGridColumnCount(2);
        options.setCropGridRowCount(1);
//        options.setToolbarCropDrawable(R.drawable.ic_done);
//        options.setToolbarCancelDrawable(R.drawable.ic_close_black_48dp);

        // Color palette
        options.setToolbarColor(ContextCompat.getColor(getContext(), R.color.bg_head));
        options.setStatusBarColor(ContextCompat.getColor(getContext(), R.color.bg_head));
//        options.setActiveWidgetColor(ContextCompat.getColor(getContext(), R.color.bg_head));
//        options.setToolbarWidgetColor(ContextCompat.getColor(getContext(), R.color.bg_head));
        options.setRootViewBackgroundColor(ContextCompat.getColor(getContext(), R.color.black_font));

//        // Aspect ratio options
        options.setAspectRatioOptions(1, new AspectRatio("Aspect", 1, 1));
        /*options.setAspectRatioOptions(1,
                new AspectRatio("WOW", 1, 2),
                new AspectRatio("MUCH", 3, 4),
                new AspectRatio("RATIO", CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO),
                new AspectRatio("SO", 16, 9),
                new AspectRatio("ASPECT", 1, 1));*/


        return uCrop.withOptions(options);
    }

    private File copyFileToDisk(Uri uri) {
        return saveBitmap(decodeUriAsBitmap(getActivity(), uri));
    }

    public static Bitmap decodeUriAsBitmap(Context context, Uri uri) {
        if (context == null || uri == null) return null;
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri));
            ToastUtil.show("save!!!!!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return bitmap;
    }

    /**
     * @param bm
     */
    public File saveBitmap(Bitmap bm) {
        File mDir = new File(getSDCardPath(), path);
        Log.e(TAG, "保存图片");
        if (!mDir.exists()) {
            mDir.mkdirs();
        }
        File file = new File(mDir, picName);
        ToastUtil.show(file.toString());
        try {
            FileOutputStream out = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.JPEG, 80, out);
            out.flush();
            out.close();
            Log.i(TAG, "已经保存");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return file;
    }

    private void displayImage(String imagePath) {
        if (null != imagePath) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            cvHead.setImageBitmap(bitmap);
        } else {
            ToastUtil.show("图片获取失败");
        }
    }

    private Bitmap getDiskBitmap(File file) {
        Bitmap bitmap = null;
        try {
            if (file.exists()) {
                bitmap = BitmapFactory.decodeFile(file.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return bitmap;
    }


    private void applyPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
                && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermission(Manifest.permission.READ_EXTERNAL_STORAGE,
                    "允许应用获取读写权限",
                    REQUEST_STORAGE_READ_ACCESS_PERMISSION);
        }
    }

    protected void requestPermission(final String permission, String rationale, final int requestCode) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), permission)) {
            showAlertDialog("申请权限", rationale,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(getActivity(),
                                    new String[]{permission}, requestCode);
                        }
                    }, "确定", null, "取消");
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{permission}, requestCode);
        }
    }

    protected void showAlertDialog(@Nullable String title, @Nullable String message,
                                   @Nullable DialogInterface.OnClickListener onPositiveButtonClickListener,
                                   @NonNull String positiveText,
                                   @Nullable DialogInterface.OnClickListener onNegativeButtonClickListener,
                                   @NonNull String negativeText) {
        AlertDialog.Builder builder = new AlertDialog.Builder(App.getApplication());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positiveText, onPositiveButtonClickListener);
        builder.setNegativeButton(negativeText, onNegativeButtonClickListener);
        mAlertDialog = builder.show();
    }


    public static String getSDCardPath() {
        String cmd = "cat /proc/mounts";
        Runtime run = Runtime.getRuntime();// 返回与当前 Java 应用程序相关的运行时对象
        try {
            Process p = run.exec(cmd);// 启动另一个进程来执行命令
            BufferedInputStream in = new BufferedInputStream(p.getInputStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));

            String lineStr;
            while ((lineStr = inBr.readLine()) != null) {
                // 获得命令执行后在控制台的输出信息
                if (lineStr.contains("sdcard")
                        && lineStr.contains(".android_secure")) {
                    String[] strArray = lineStr.split(" ");
                    if (strArray != null && strArray.length >= 5) {
                        String result = strArray[1].replace("/.android_secure",
                                "");
                        return result;
                    }
                }
                // 检查命令是否执行失败。
                if (p.waitFor() != 0 && p.exitValue() == 1) {
                    // p.exitValue()==0表示正常结束，1：非正常结束
                }
            }
            inBr.close();
            in.close();
        } catch (Exception e) {

            return Environment.getExternalStorageDirectory().getPath();
        }

        return Environment.getExternalStorageDirectory().getPath();
    }


}


