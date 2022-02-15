package com.example.cardholder

import com.google.zxing.Result
import com.king.zxing.CameraScan
import com.king.zxing.analyze.MultiFormatAnalyzer
import com.king.zxing.DecodeFormatManager
import com.king.zxing.DecodeConfig
import com.king.zxing.CaptureActivity
import android.widget.Toast
import android.content.Context
import android.content.Intent
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


class ScanActivity : CaptureActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_scan
    }

    override fun initCameraScan() {
        super.initCameraScan()

        val decodeConfig = DecodeConfig()
        decodeConfig.setHints(DecodeFormatManager.DEFAULT_HINTS)
            .setFullAreaScan(false)
            .setAreaRectRatio(0.8f)
            .setAreaRectVerticalOffset(0).areaRectHorizontalOffset = 0

        cameraScan
            .setVibrate(true)
            .setNeedAutoZoom(true)
            .setAnalyzer(MultiFormatAnalyzer(decodeConfig))
    }

    override fun onScanResultCallback(result: Result?): Boolean {
        cameraScan.setAnalyzeImage(false)
        val intent = Intent(this, MainActivity::class.java).apply{
            if (result != null) {
                putExtra("ScanResult",arrayOf<String>(result.text, result.barcodeFormat.toString()))
            }
        }
        startActivity(intent)
//        return super.onScanResultCallback(result)
        return false
    }
}