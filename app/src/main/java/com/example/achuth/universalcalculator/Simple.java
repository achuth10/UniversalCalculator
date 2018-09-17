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
        Button delete=(Button)findViewById(R.id.delete);

        delete.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
//                Toast.makeText(getApplicationContext(),
//                        "You have pressed it long :)", Toast.LENGTH_LONG).show();
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
        display();
        lastnum = true;

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
        display();
        onscreen=input;
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
        TextView T = (TextView) findViewById(R.id.input);
        T.setText(" " + onscreen);
        //T.setText(" " + input);
    }
    public void display(String s) {
        TextView T = (TextView) findViewById(R.id.input);
        T.setText(s);
    }


    public void eval(View view) {

        TextView T = (TextView) findViewById(R.id.input);
        //System.out.println("new input " + input);


        if (input==" "|| lastnum==false)
        {
            T.setText("Error");
            input=" ";
            onscreen=input;

        }
        else
        {

            working W=new working();
           // double result=W.driver(input);


            //changed code
            double result=W.driver(input);
           // System.out.println(result);
            T.setText(" "+ result);
            //here is what changed
            input=" " +result;
            onscreen=input;

            //input = " ";
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
        for(int m=0;m<=onscreen.length();m++)
        {
            if(onscreen.charAt(m)==' ')
                continue;
            else if(onscreen.charAt(m)=='('&&onscreen.charAt(m+1)==')')
            {
                TextView text=(TextView)findViewById(R.id.input);
                input=" ";
                onscreen=" ";
                //Log.e("LOG tag", input);
                text.setText("Error");
                break;
            }
            else if (onscreen.charAt(m)=='('&&onscreen.charAt(m+1)!=')')
                break;
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
            else if(c=='^')
                return true;
            else
                return false;
        }

        public  boolean hasPrecedence(char op1, char op2) {

            if (op2 == '(' || op2 == ')')
                return false;
            if ((op1 == '*' || op1 == '/' ) && (op2 == '+' || op2 == '-'))
                return false;
            else
                return true;
        }
        public  double applyOp(char op, double b, double  a) {
            /*System.out.println("entered ops metho");
            System.out.println("The operand is " + op);
            System.out.println("value of a and b " + a + " and  "+ b);*/
            switch (op) {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
                case '^':
                   // System.out.println("Entered here and value is "+Math.pow(a,b));
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
            //System.out.println("Expression length and exp is " +s.length() + s);
            Stack<Double> numbers=new Stack<Double>();
            Stack<Character> operands=new Stack<Character>();

            for(int i=0;i<s.length()-1;i++)
            {
                //System.out.println("Loop begining " + i );

                if(s.charAt(i)==' ')
                    continue;
                if(Character.isDigit(s.charAt(i)))
                {
                    StringBuffer temp = new StringBuffer();
                    while(i<s.length() && Character.isDigit(s.charAt(i)))
                    {
                        //System.out.println("While counter , i = "+i );
                        temp.append(s.charAt(i++));
                    }
                    numbers.push(Double.parseDouble(temp.toString()));
                    //System.out.println("value of i after number pushing " +i);
                    //System.out.println(numbers.peek());
                }

                if(isOperand(s.charAt(i)))
                {
                    //System.out.println("Entered operand test case");
                    TextView t=(TextView)findViewById(R.id.input);
                    if(isOperand(s.charAt(i+1)))
                    {
                        t.setText("Error");
                        input=" ";
                        break;
                    }
                    while (!operands.empty() && hasPrecedence(s.charAt(i), operands.peek()))
                    {
                        //System.out.println("value of i inside operand pushing statement"+ i);
                        numbers.push(applyOp(operands.pop(), numbers.pop(), numbers.pop()));
                    }
                    operands.push(s.charAt(i));
                    System.out.println(operands.peek());
                }
                //System.out.println("value of i after operand pushing statement"+ i);
                else if(s.charAt(i)=='(')
                {
                    //ystem.out.println("entered ( teest case ");
                    operands.push(s.charAt(i));
                }
                //System.out.println("before pooping th elements in stack ");
                //for(int l=0;l<numbers.size();l++)
                   // System.out.println(numbers.get(l));
                if (s.charAt(i)== ')') {
                    while (operands.peek() != '(')
                        numbers.push(applyOp(operands.pop(), numbers.pop(), numbers.pop()));
                    operands.pop();
                }

                else if(s.charAt(i)=='.')
                {
                    double newnum=0,k=1;double tempnum;
                    newnum=numbers.pop();
                    //System.out.println("number already in stack" +newnum);
                    while(!isOperand(s.charAt(i+1)))
                    {
                        //System.out.println("Entered the . checking, i =  "+ i );
                        StringBuffer temp = new StringBuffer();
                        temp.append(s.charAt(i+1));

                        tempnum=Double.parseDouble(temp.toString());
                        //System.out.println("Temp num is " +tempnum);
                        //System.out.println("10^(-k) "+ Math.pow(10, -k));
                        //System.out.println("prod of tem num and exponential" +tempnum*(Math.pow(10, -k)));
                        newnum+=tempnum*(Math.pow(10, -k));
                        //System.out.println("new number is " +newnum);
                        i++;
                        k++;
                    }

                    numbers.push(newnum);
                    //System.out.println(numbers.peek());
                }


            }
            //System.out.println("reached end of parsing with operand " +  operands.peek());
            while (!operands.empty()&&numbers.size()>1)
            {
                //System.out.println("inside operands ! empty");

                numbers.push(applyOp(operands.pop(), numbers.pop(),numbers.pop()));

            }
            return numbers.pop();

        }
    }




}