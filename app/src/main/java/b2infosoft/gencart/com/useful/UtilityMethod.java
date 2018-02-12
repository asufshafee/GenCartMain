package b2infosoft.gencart.com.useful;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Pankaj on 4/21/2016.
 */
public class UtilityMethod {


    public static void goNextClass(Context context, Class className) {

        Intent intent = new Intent(context, className);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }


    //Comapare Imageview and Drawable

    public static boolean checkImageResource(Context ctx, ImageView imageView, int imageResource) {
        boolean result = false;

        if (ctx != null && imageView != null && imageView.getDrawable() != null) {
            Drawable.ConstantState constantState;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                constantState = ctx.getResources()
                        .getDrawable(imageResource, ctx.getTheme())
                        .getConstantState();
            } else {
                constantState = ctx.getResources().getDrawable(imageResource)
                        .getConstantState();
            }

            if (imageView.getDrawable().getConstantState() == constantState) {
                result = true;
            }
        }

        return result;
    }

    public static void showAlertBox(Context context, String msg) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set title
        //  alertDialogBuilder.setTitle("Your Title");
        // set dialog message
        alertDialogBuilder
                .setMessage(msg)
                .setCancelable(true)
                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    public static void showToast(Context context, String message) {

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

    }

    /*public static void showAlertBoxwithIntentClearHistory(final Context context, String msg, final Class class1) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder
                .setMessage(msg)
                .setCancelable(false)
                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(context, class1);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                });


        // create alert dialog
        final AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
        alertDialog.dismiss();
        Intent intent = new Intent(context, class1);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }*/


    public static void showAlertBoxwithIntent(final Context context, String msg, final Class class1) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder
                .setMessage(msg)
                .setCancelable(false)
                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                        Intent intent = new Intent(context, class1);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent);
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    public static String encodeToBase64(Bitmap image, Bitmap.CompressFormat compressFormat, int quality) {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(compressFormat, quality, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
    }

    public static Bitmap decodeBase64(String input) {
        byte[] decodedBytes = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }


    //method for click images or get from gallary
    public static void selectImage(final Activity activity) {
        final CharSequence[] option1 = {"Take Photo", "Choose from Gallery", "Take selfie", "Select Multiple", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //builder.setTitle("Add Photo!");
        builder.setItems(option1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (option1[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    activity.startActivityForResult(intent, 101);
                } else if (option1[item].equals("Choose from Gallery")) {
                    Intent intent = new Intent();
                    intent.setType("image/*"); // intent.setType("video/*"); to select videos to upload
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    activity.startActivityForResult(Intent.createChooser(intent, "Select Picture"), 201);
                } else if (option1[item].equals("Take selfie")) {

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    // intent.putExtra(MediaStore.EXTRA_OUTPUT,0);
                    intent.putExtra("android.intent.extras.CAMERA_FACING", android.hardware.Camera.CameraInfo.CAMERA_FACING_FRONT);

                    activity.startActivityForResult(intent, 301);


                } else {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    public static String nameFirstLatterCapitalize(String name) {

        Log.d("name>>", name);

        String name1 = name;
        name1 = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        Log.d("nameCapitalized>>", name1);

        return name1;
    }

    //method for get Image URI
    public static Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    //method for get Image PATH
    public static String getPath(Uri uri, Activity activity) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = activity.getContentResolver().query(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    // Method to show alert dialog
    public static void showAlert(String message, Context context) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setMessage(message).setTitle("Response from Servers")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // do nothing
                    }
                });
        android.app.AlertDialog alert = builder.create();
        alert.show();
    }


    public static void captureImage(Bitmap bitmap, Intent data, ImageView imageView, String imagepath) {
        try {
            BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
            imageView.setImageBitmap(bitmap);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

            // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
            /*Uri tempUri = MyUtil.getImageUri(activity.getApplicationContext(), bitmap);
            imagepath = MyUtil.getPath(tempUri, activity);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void imageFromGallary(Intent data, String imagepath, Activity activity, ImageView imageView) {

        Uri selectedImageUri = data.getData();
        imagepath = UtilityMethod.getPath(selectedImageUri, activity);
        BitmapFactory.Options options = new BitmapFactory.Options();
        // down sizing image as it throws OutOfMemory Exception for larger images
        options.inSampleSize = 4;
        final Bitmap bitmap = BitmapFactory.decodeFile(imagepath, options);
        imageView.setImageBitmap(bitmap);
    }

    public static void showSnackBar(final View coordinatorLayout, String msg) {

        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, msg, Snackbar.LENGTH_LONG)
                .setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                    }
                });

// Changing message text color
        snackbar.setActionTextColor(Color.RED);

// Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
    }

    public static void hideKeyboardForFocusedView(Activity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    // Create First Word Capital

    public static String toTitleCase(String givenString) {
        String[] arr = givenString.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            sb.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }
        return sb.toString().trim();
    }


    @SuppressLint("SimpleDateFormat")
    public static String convertJsonDate(String jsondate) {
        jsondate = jsondate.replace("/Date(", "").replace(")/", "");
        long time = Long.parseLong(jsondate);
        Date d = new Date(time);

        //  return new SimpleDateFormat("MM/dd/yyyy").format(d).toString();
        return new SimpleDateFormat("dd/MM/yyyy").format(d).toString();
    }
}
