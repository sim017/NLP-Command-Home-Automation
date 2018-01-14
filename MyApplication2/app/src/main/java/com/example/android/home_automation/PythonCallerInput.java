package com.example.android.home_automation;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonCallerInput extends Activity {

    /**
     * @param args
     * @throws IOException
     */
    public void pyt(String args) throws IOException {
// set up the command and parameter
        String pythonScriptPath = "/home/user/Drishti_Mini_project/NLP-Command-Home-Automation/MyApplication2/app/src/main/java/com/example/android/home_automation/Text_Processing.py";
        String[] cmd = new String[3];
        cmd[0] = "python";
        cmd[1] = pythonScriptPath;
        cmd[2] = args;
// create runtime to execute external command
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec(cmd,null,null);
        //TextView txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);

// retrieve output from python script
        BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line = "";
        while((line = bfr.readLine()) != null) {
// display each output line form python script
            //txtSpeechInput.setText(line);
            System.out.println(line);
        }
    }
}