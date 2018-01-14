package com.example.android.home_automation;

import android.content.Context;

import org.python.core.PyInstance;
import org.python.util.PythonInterpreter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Text_processing {

    PythonInterpreter interpreter = null;
    private Context context;

    public Text_processing(Context context) {
        this.context = context;
        PythonInterpreter.initialize(System.getProperties(),
                System.getProperties(), new String[0]);
        this.interpreter = new PythonInterpreter();
    }

    void execfile(final String fileName) {
        this.interpreter.execfile(fileName);
    }

    PyInstance createClass(final String className, final String opts) {
        return (PyInstance) this.interpreter.eval(className + "(" + opts + ")");
    }

    public void str(String str1) {
        /*String scriptName = "Text_Processing";
        try{
            interpreter.exec("import sys\n" + "import os \n" + "from "+scriptName+" import * \n");
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
        interpreter.exec(scriptName);
        String funcName = "text";
        PyObject someFunc = interpreter.get(funcName);
            someFunc.__call__(new PyString(str1));
        } catch (PyException e) {
            e.printStackTrace();
        }*/
        String[] arguments = {"Text_Processing.py", str1};
        PythonInterpreter.initialize(System.getProperties(), System.getProperties(), arguments);
        org.python.util.PythonInterpreter python = new org.python.util.PythonInterpreter();
        OutputStream out = new OutputStream() {
            @Override
            public void write(int i) throws IOException {

            }
        };
        python.setOut(out);
        //String code = this.getAssets().open("text_processing.py").toString();
        String code = "def text(z):\n" +
                "    pp=z.lower()\n" +
                "    noun=[\"fan\",\"light\",\"lights\",\"fans\"]\n" +
                "    verb=[\"on\",\"off\"]\n" +
                "    compound=[\"and\",\"but\"]\n" +
                "    token=pp.split(\",\")\n" +
                "    noune=list(set(token)& set(noun))\n" +
                "    verbo=list(set(token)& set(verb))\n" +
                "    compounde=list(set(token)& set(compound))\n" +
                "    x=len(noune)\n" +
                "    y=len(verbo)\n" +
                "    a=len(compound)\n" +
                "    g=verbo[0]\n" +
                "    u=0\n" +
                "    light=3\n" +
                "    fan=3\n" +
                "    for g in g:\n" +
                "        u=u+ord(g)\n" +
                "    if(a>0 and y>1):\n" +
                "        b=pp.index(\"on\")\n" +
                "        c=pp.index(\"off\")\n" +
                "        d=pp.index(\"light\"or \"lights\")\n" +
                "        e=pp.index(\"fan\"or \"fans\")\n" +
                "        g=abs(d-c)\n" +
                "        h=abs(d-b)\n" +
                "        if(g>h):\n" +
                "            light=1\n" +
                "            fan=0\n" +
                "        else:\n" +
                "            light=0\n" +
                "            fan=1\n" +
                "    if(x==2 and y==1):\n" +
                "        if u==315:\n" +
                "            light=0\n" +
                "            fan=0\n" +
                "        else:\n" +
                "            light=1\n" +
                "            fan=1\n" +
                "    if(((\"light\" or \"lights\")in noune) and (u==315)):\n" +
                "        light=0\n" +
                "    elif(((\"light\" or \"lights\")in noune) and (u!=315)):\n" +
                "        light=1\n" +
                "    if(((\"fan\" or \"fans\")in noune)and (u==315)):\n" +
                "        fan=0\n" +
                "    elif(((\"fans\" or \"fan\") in noune) and (u!=315)):\n" +
                "        fan=1\n" +
                "    print (\"Yeah\")";

        try {
            FileOutputStream outputStream = context.openFileOutput("script.py", Context.MODE_PRIVATE);
            outputStream.write(code.getBytes());
            outputStream.close();

            File file = new File(context.getFilesDir() + "/script.py");
            python.execfile(file.getAbsolutePath());
        } catch (IOException e) {

        }
        String outputStr = out.toString();
        System.out.println(outputStr);
    }
}