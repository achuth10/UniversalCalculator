package com.example.achuth.universalcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import android.view.View.OnLongClickListener;

public class Simple extends AppCompatActivity {
    String input = " ",display=" ",onscreen=" ";
    boolean lastnum = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        Button delete= findViewById(R.id.delete);

        delete.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub

                input=" ";
                onscreen=input;
                display();
                lastnum=false;
                return true;
            }
        });
    }




    public void input1(View view) {
        input += "1";
        onscreen=input;
        lastnum = true;
        display();


    }

    public void input2(View view) {
        input += "2";
        lastnum = true;
        onscreen=input;
        display();

    }

    public void input3(View view) {
        input += "3";
        lastnum = true;
        onscreen=input;
        display();
    }

    public void input4(View view) {
        input += "4";
        lastnum = true;
        onscreen=input;
        display();
    }

    public void input5(View view) {
        input += "5";
        lastnum = true;
        onscreen=input;
        display();

    }

    public void input6(View view) {
        input += "6";
        onscreen=input;
        lastnum = true;
        display();
    }

    public void input7(View view) {
        input += "7";
        lastnum = true;
        onscreen=input;
        display();
    }

    public void input8(View view) {
        input += "8";
        lastnum = true;
        onscreen=input;
        display();
    }

    public void input9(View view) {
        input += "9";
        lastnum = true;
        onscreen=input;
        display();
    }

    public void inputplus(View view) {
        input += "+";
        lastnum = false;
        onscreen=input;
        display();
    }

    public void inputsub(View view) {
        input += "-";
        lastnum = false;
        onscreen=input;
        display();
    }

    public void inputdiv(View view) {
        input += "/";
        lastnum = false;
        onscreen=input;
        display();
    }

    public void inputprod(View view) {
        input += "*";
        lastnum = false;
        onscreen=input;
        display();
    }
    public void inputdec(View view) {
        input += ".";
       lastnum=false;
        onscreen=input;
        display();
    }

    public void input0(View view) {
        input += "0";
        lastnum = true;
        onscreen=input;
        display();
    }
    public void del(View view)

    {
        if (input.length() >= 1) {
            input = input.substring(0, input.length() - 1);
            onscreen=input;
            display();
        } else {
            input = "0";
            onscreen=input;
            lastnum = false;
        }
    }

    public void display() {
        TextView T = findViewById(R.id.input);
        T.setText(" " + onscreen);
    }
    public void display(String s) {
        TextView T = findViewById(R.id.input);
        T.setText(s);
    }


    public void eval(View view) {

        TextView T = findViewById(R.id.input);


        if (input==" "|| lastnum==false)
        {
            T.setText("Error");
            input=" ";
            onscreen=input;

        }
        else
        {

            working W=new working();
            double result=W.driver(input);
            T.setText(" "+ result);
            input=" " +result;
            onscreen=input;
        }

    }

    public void inputbracketopen(View view) {
        input+="(";
        onscreen=input;
        display();
    }

    public void inputbracketclose(View view) {
        input+=")";
        onscreen=input;
        display();
        TextView text= findViewById(R.id.input);
        for(int m=0;m<=onscreen.length();m++)
        {
            if(onscreen.charAt(m)==' ')
                continue;
            else if(onscreen.charAt(m)=='('&&onscreen.charAt(m+1)==')')
            {

                input=" ";
                onscreen=" ";
                text.setText("Error");
                break;
            }
            else if (onscreen.charAt(m)=='('&&onscreen.charAt(m+1)!=')')
                break;
            else if(onscreen.charAt(m)==')' && onscreen.charAt(m-1)!='(' )
            {
                text.setText("Error");
                break;
            }
        }

    }

    public void inputexpo(View view) {
        input+="^";
        onscreen=input;
        display();
    }




    class working{

        public boolean isOperand(char c)
        {
            if(c=='*')
                return true;
            else if(c=='+')
                return true;
            else if(c=='/')
                return true;
            else if(c=='-')
                return true;
            else return c == '^';
        }

        public  boolean hasPrecedence(char op1, char op2) {

            if (op2 == '(' || op2 == ')')
                return false;
            return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
        }
        public  double applyOp(char op, double b, double  a) {
            switch (op) {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
                case '^':
                    return Math.pow(a,b);
                case '/':
                    if (b == 0)
                        System.out.println("Cannot divide by zero!");
                    return a / b;
            }
            return 0;
        }

        public Double driver(String s)
        {
            s="("+s+"+0)";
            Stack<Double> numbers=new Stack<Double>();
            Stack<Character> operands=new Stack<Character>();

            for(int i=0;i<s.length()-1;i++)
            {

                if(s.charAt(i)==' ')
                    continue;
                if(Character.isDigit(s.charAt(i)))
                {
                    StringBuffer temp = new StringBuffer();
                    while(i<s.length() && Character.isDigit(s.charAt(i)))
                    {
                        temp.append(s.charAt(i++));
                    }
                    numbers.push(Double.parseDouble(temp.toString()));
                }

                if(isOperand(s.charAt(i)))
                {
                    TextView t= findViewById(R.id.input);
                    if(isOperand(s.charAt(i+1)))
                    {
                        t.setText("Error");
                        input=" ";
                        break;
                    }
                    while (!operands.empty() && hasPrecedence(s.charAt(i), operands.peek()))
                    {
                        numbers.push(applyOp(operands.pop(), numbers.pop(), numbers.pop()));
                    }
                    operands.push(s.charAt(i));
                    System.out.println(operands.peek());
                }
                else if(s.charAt(i)=='(')
                {
                    operands.push(s.charAt(i));
                }
                if (s.charAt(i)== ')') {
                    while (operands.peek() != '(')
                        numbers.push(applyOp(operands.pop(), numbers.pop(), numbers.pop()));
                    operands.pop();
                }

                else if(s.charAt(i)=='.')
                {
                    double newnum=0,k=1;double tempnum;
                    newnum=numbers.pop();
                    while(!isOperand(s.charAt(i+1)))
                    {
                        StringBuffer temp = new StringBuffer();
                        temp.append(s.charAt(i+1));
                        tempnum=Double.parseDouble(temp.toString());
                        newnum+=tempnum*(Math.pow(10, -k));
                        i++;
                        k++;
                    }
                    numbers.push(newnum);
                }


            }
            while (!operands.empty()&&numbers.size()>1)
            {

                numbers.push(applyOp(operands.pop(), numbers.pop(),numbers.pop()));

            }
            return numbers.pop();

        }
    }




}