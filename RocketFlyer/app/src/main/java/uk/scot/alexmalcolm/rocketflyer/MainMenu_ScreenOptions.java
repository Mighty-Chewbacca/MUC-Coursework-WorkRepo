package uk.scot.alexmalcolm.rocketflyer;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainMenu_ScreenOptions extends AppCompatActivity implements View.OnClickListener
{
    Button btnReturn;
    ToggleButton tbSoundToggle;
    FragmentManager fmAboutDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_screen_options);

        fmAboutDialog = this.getFragmentManager();

        btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);

        tbSoundToggle = (ToggleButton) findViewById(R.id.tbSoundToggle);
        tbSoundToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    // The toggle is enabled so allow sounds
                    Log.e("Debug", "Sound toggled on");
                }
                else
                {
                    // The toggle is disabled so mute the sound
                    Log.e("Debug", "Sound toggled off");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mc_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.mQuit:
                Log.e("Debug", "quit pressed in top menu on options screen");
                finish();
                return true;

            case R.id.mAbout:
                Log.e("Debug", "about button pressed in top menu on options screen");
                DialogFragment mcAboutDlg = new AboutDialog();
                mcAboutDlg.show(fmAboutDialog, "mc_About_Dlg");
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.btnReturn:
                //return to the main menu
                Log.e("Debug", "Return pressed in Options Menu");
                setResult(Activity.RESULT_OK);
                finish();
                break;
            default:
                break;
        }
    }
}
