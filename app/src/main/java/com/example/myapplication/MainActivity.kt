package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.activitys.HomeActivity
import com.example.myapplication.activitys.ShowProfileSaleListAdapter
import com.example.myapplication.activitys.ShowProfileShareListAdapter
import com.example.myapplication.activitys.SplashActivity
import com.example.myapplication.data.SaleData
import com.example.myapplication.data.ShareData
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        // HomeActivity를 시작하는 Intent 생성
        val intent = Intent(this@MainActivity, SplashActivity::class.java)

        // Intent를 사용하여 HomeActivity 시작
        startActivity(intent)
        //finish()
    }
}
