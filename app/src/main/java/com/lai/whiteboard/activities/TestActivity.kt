package com.lai.whiteboard.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.lai.whiteboard.R
import com.lai.whiteboard.databinding.ActivityTestBinding
import kotlin.system.exitProcess

class TestActivity : AppCompatActivity() {

	private val binding by lazy {
		ActivityTestBinding.inflate(layoutInflater)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)
		if (savedInstanceState == null) {
			supportFragmentManager.beginTransaction().replace(R.id.settings, TestFragment()).commit()
		}
	}

	class TestFragment : PreferenceFragmentCompat() {
		override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
			setPreferencesFromResource(R.xml.test, rootKey)
			// 退出
			findPreference<Preference>("quit_app")!!.onPreferenceClickListener =
				Preference.OnPreferenceClickListener {
					exitProcess(0)
				}
			findPreference<Preference>("quit_app1")!!.onPreferenceClickListener =
				Preference.OnPreferenceClickListener {
					exitProcess(0)
				}
			findPreference<Preference>("quit_app2")!!.onPreferenceClickListener =
				Preference.OnPreferenceClickListener {
					exitProcess(0)
				}
		}
	}

}
