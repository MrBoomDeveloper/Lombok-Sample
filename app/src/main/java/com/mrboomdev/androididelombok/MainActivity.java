package com.mrboomdev.androididelombok;

import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.widget.Toast;
import com.mrboomdev.androididelombok.databinding.ActivityMainBinding;
import lombok.*;

public class MainActivity extends AppCompatActivity {
	private ActivityMainBinding binding;
	@Getter private LombokSample sample;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		binding = ActivityMainBinding.inflate(getLayoutInflater());
		setSupportActionBar(binding.toolbar);
        setContentView(binding.getRoot());
		
		try {
			startSample();
			Toast.makeText(this, "Everything is working ok!", Toast.LENGTH_SHORT).show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	private void startSample() {
		//AndeoidIDE says that the constructor is private. Everything compiles and works ok!
		//Just look at the diagnostics tab! Everything is red!
		//Even Androids generated databinding is working ok
		sample = new LombokSample().build();
		Toast.makeText(this, sample.getMessage(), Toast.LENGTH_SHORT).show();
		
		var built = LombokSample.builder()
			.age(16)
			.message("Amogus!")
			.build();
		Toast.makeText(this, String.valueOf(built.getAge()), Toast.LENGTH_SHORT).show();
		
		var allArgsSample = new LombokSample("Hi", 4, 1);
		Toast.makeText(this, allArgsSample.getAge() + " : " + allArgsSample.getMessage(), Toast.LENGTH_SHORT).show();
		
		var anotherBuilder = LombokSample.builder().build();
		Toast.makeText(this, String.valueOf(anotherBuilder.getAge()), Toast.LENGTH_SHORT).show();
		Toast.makeText(this, "Is same: " + String.valueOf(anotherBuilder.getAge() == anotherBuilder.age), Toast.LENGTH_SHORT).show();
	}
}