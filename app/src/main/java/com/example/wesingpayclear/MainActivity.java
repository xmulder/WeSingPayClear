package com.example.wesingpayclear;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private Button button_start_vpn;
    private Button button_uninstall_wesing;
    private Button button_clear_googleplay_cache;
    private Button button_clear_googleservice_cache;
    private Button button_clear_googleserviceframework_cache;
    private Button button_clear_googlepartnersetup_cache;
    private Button button_clear_google_cache;
    private Button button_install_wesing_googleplay;
    private Button button_zip_wesing_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("使用须知");
        builder.setMessage("1.全程连接VPN.\n2.本机只保留可支付的Google账号,其他账号请删除.\n3.按照以下步骤完成后,重新安装带有google签名的WeSing版本.");
        builder.setPositiveButton("继续", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();

        button_start_vpn=(Button)findViewById(R.id.button_start_vpn);
        button_start_vpn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PackageManager packageManager=getPackageManager();
                if(checkPackageInfo("com.expressvpn.vpn")){
                    Intent intent=packageManager.getLaunchIntentForPackage("com.expressvpn.vpn");
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"Please install Express VPN in Google Play first.",Toast.LENGTH_LONG).show();
                    Uri installExpressVpn=Uri.parse("https://play.google.com/store/apps/details?id=com.expressvpn.vpn");
                    Intent intentInstallExpressVpn=new Intent(Intent.ACTION_VIEW,installExpressVpn);
                    startActivity(intentInstallExpressVpn);
                }
            }

            private boolean checkPackageInfo(String packagename){
                PackageInfo packageInfo=null;
                try{
                    packageInfo=getPackageManager().getPackageInfo(packagename,0);
                }catch (PackageManager.NameNotFoundException e){
                    e.printStackTrace();
                }
                return packageInfo!=null;
            }

        });


        button_uninstall_wesing=(Button)findViewById(R.id.button_uninstall_wesing);
        button_uninstall_wesing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uninstallWeSing=Uri.fromParts("package","com.tencent.wesing",null);
                Intent uninstallIntent=new Intent(Intent.ACTION_DELETE,uninstallWeSing);
                startActivity(uninstallIntent);
            }
        });

        button_clear_googleplay_cache=(Button)findViewById(R.id.button_clear_googleplay_cache);
        button_clear_googleplay_cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri clearGooglePlayCache=Uri.fromParts("package","com.android.vending",null);
                Intent intentGooglePlay=new Intent("android.settings.APPLICATION_DETAILS_SETTINGS",clearGooglePlayCache);
                startActivity(intentGooglePlay);
            }
        });

        button_clear_googleservice_cache=(Button)findViewById(R.id.button_clear_google_service);
        button_clear_googleservice_cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri clearGoogleServiceCache=Uri.fromParts("package","com.google.android.gms",null);
                Intent intentGoogleService=new Intent("android.settings.APPLICATION_DETAILS_SETTINGS",clearGoogleServiceCache);
                startActivity(intentGoogleService);
            }
        });

        button_clear_googleserviceframework_cache=(Button)findViewById(R.id.button_clear_google_gsf);
        button_clear_googleserviceframework_cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri clearGoogleServiceFramework=Uri.fromParts("package","com.google.android.gsf",null);
                Intent intentGoogleServiceFramework=new Intent("android.settings.APPLICATION_DETAILS_SETTINGS",clearGoogleServiceFramework);
                startActivity(intentGoogleServiceFramework);
            }
        });

        button_clear_googlepartnersetup_cache=(Button)findViewById(R.id.button_clear_google_partnersetup);
        button_clear_googlepartnersetup_cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri clearGooglePartnerSetup=Uri.fromParts("package","com.google.android.partnersetup",null);
                Intent intentGooglePartnerSetup=new Intent("android.settings.APPLICATION_DETAILS_SETTINGS",clearGooglePartnerSetup);
                startActivity(intentGooglePartnerSetup);
            }
        });

        button_clear_google_cache=(Button)findViewById(R.id.button_clear_google_cache);
        button_clear_google_cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri clearGoogle=Uri.fromParts("package","com.google.android.googlequicksearchbox",null);
                Intent intentGoogle=new Intent("android.settings.APPLICATION_DETAILS_SETTINGS",clearGoogle);
                startActivity(intentGoogle);
            }
        });

        button_install_wesing_googleplay=(Button)findViewById(R.id.button_install_wesing_googleplay);
        button_install_wesing_googleplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri installWesingGooglePlay=Uri.parse("https://play.google.com/store/apps/details?id=com.tencent.wesing");
                Intent intentWesingGooglePlay=new Intent(Intent.ACTION_VIEW,installWesingGooglePlay);
                startActivity(intentWesingGooglePlay);
            }
        });

        button_zip_wesing_log=(Button)findViewById(R.id.button_zip_wesing_log);
        button_zip_wesing_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sourceFile="/storage/self/primary/tencent/wns/Logs/com.tencent.wesing/";
                String zipFile="/storage/emulated/0/wesing.zip";
                CompressOperate_zip4j file=new CompressOperate_zip4j();
                file.compressZip4j(sourceFile,zipFile,null);

                File file1=new File(zipFile);
                if (file1.exists()){
                    Toast.makeText(MainActivity.this,"Zip WeSing Local log successful",Toast.LENGTH_SHORT).show();
                }

                File zipFilePath = new File("/storage/emulated/0/");
                File zipFiletoShare=new File(zipFilePath,"wesing.zip");
                Uri contentUri= (Uri) FileProvider.getUriForFile(MainActivity.this,BuildConfig.APPLICATION_ID+".provider",zipFiletoShare);

                Intent shareIntent=new Intent(Intent.ACTION_SEND);
                shareIntent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                shareIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                shareIntent.addCategory("android.intent.category.DEFAULT");
                shareIntent.setType("application/zip");
                shareIntent.putExtra(Intent.EXTRA_STREAM,contentUri);
                startActivity(Intent.createChooser(shareIntent,"Share to......"));
            }
        });
    }
}
