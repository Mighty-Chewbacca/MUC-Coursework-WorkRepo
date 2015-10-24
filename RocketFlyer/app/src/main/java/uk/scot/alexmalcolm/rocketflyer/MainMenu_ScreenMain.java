package uk.scot.alexmalcolm.rocketflyer;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainMenu_ScreenMain  extends AppCompatActivity implements View.OnClickListener
{
    Button btnHelp;
    Button btnPlay;
    Button btnOptions;

    FragmentManager fmAboutDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu__screen_main);

        fmAboutDialog = this.getFragmentManager();

        btnHelp = (Button) findViewById(R.id.btnHelp);
        btnHelp.setOnClickListener(this);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(this);

        btnOptions = (Button) findViewById(R.id.btnOptions);
        btnOptions.setOnClickListener(this);
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
                finish();
                return true;

            case R.id.mAbout:
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
            case R.id.btnOptions:
                //change to the options intent
                break;
            case R.id.btnHelp:
                //change to the help intent
                Intent MainMenu_ScreenHelp = new Intent(getApplicationContext(), uk.scot.alexmalcolm.rocketflyer.MainMenu_ScreenHelp.class);
                //give the new intent any extras its going to need here
                startActivity(MainMenu_ScreenHelp);
                break;
            case R.id.btnPlay:
                //change to the play intent
                break;
            default:
                break;
        }
    }
}
