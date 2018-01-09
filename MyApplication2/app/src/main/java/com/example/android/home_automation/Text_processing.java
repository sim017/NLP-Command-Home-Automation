package com.example.android.home_automation;

import android.app.Activity;

import org.python.core.PyInstance;
import org.python.util.PythonInterpreter;

public class Text_processing extends Activity
{

    PythonInterpreter interpreter = null;


    public Text_processing()
    {
        PythonInterpreter.initialize(System.getProperties(),
                System.getProperties(), new String[0]);

        this.interpreter = new PythonInterpreter();
    }

    void execfile( final String fileName )
    {
        this.interpreter.execfile(fileName);
    }

    PyInstance createClass( final String className, final String opts )
    {
        return (PyInstance) this.interpreter.eval(className + "(" + opts + ")");
    }

    public void str(String str1)
    {
        String scriptName = "Text_Processing";
        try{
            interpreter.exec("import sys\n" + "import os \n" + "from "+scriptName+" import * \n");
        }catch (Exception e){
            e.printStackTrace();
        }
        /*try {
        interpreter.exec(scriptName);
        String funcName = "text";
        PyObject someFunc = interpreter.get(funcName);
            someFunc.__call__(new PyString(str1));
        } catch (PyException e) {
            e.printStackTrace();
        }*/
    }
} 