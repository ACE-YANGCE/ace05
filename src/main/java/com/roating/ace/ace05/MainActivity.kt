package com.roating.ace.ace05

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.roating.ace.ace05.autoText.AutoLinkMode
import com.roating.ace.ace05.autoText.AutoLinkOnClickListener
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.widget.Toast
import com.roating.ace.ace05.autoText.AutoLinkOnLongClickListener


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_tv.addAutoLinkMode(
                AutoLinkMode.MODE_HASHTAG,
                AutoLinkMode.MODE_PHONE,
                AutoLinkMode.MODE_URL,
                AutoLinkMode.MODE_EMAIL,
                AutoLinkMode.MODE_MENTION)

        main_tv.setHashtagModeColor(ContextCompat.getColor(this, R.color.color2))
        main_tv.setPhoneModeColor(ContextCompat.getColor(this, R.color.color3))
        main_tv.setCustomModeColor(ContextCompat.getColor(this, R.color.color1))
        main_tv.setMentionModeColor(ContextCompat.getColor(this, R.color.color5))

        main_tv.text = resources.getString(R.string.long_text)

        main_tv.setAutoLinkOnClickListener(AutoLinkOnClickListener { autoLinkMode, matchedText -> showMyDialog(autoLinkMode.toString(), matchedText) })

        main_tv.setAutoLinkOnLongClickListener(AutoLinkOnLongClickListener { autoLinkMode, matchedText ->
            Toast.makeText(this, "Long Click:" + matchedText, Toast.LENGTH_SHORT).show()
        })
    }

    fun showMyDialog(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
                .setTitle(title)
                .setCancelable(false)
                .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, id -> dialog.dismiss() })
        val alert = builder.create()
        alert.show()
    }
}
