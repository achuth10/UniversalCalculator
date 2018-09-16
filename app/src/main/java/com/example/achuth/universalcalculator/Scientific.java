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

public class Scientific extends AppCompatActivity {
    String input = " ",display=" ",onscreen=" ";
    boolean lastnum = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific);
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
        onscreen += "1";
        lastnum = true;
        input+='1';
        display();
    }

    public void input2(View view) {
        onscreen += "2";
        lastnum = true;
        input+='2';
        display();

    }

    public void input3(View view) {
        onscreen += "3";
        lastnum = true;
        input+='3';
        display();
    }

    public void input4(View view) {
        onscreen += "4";
        lastnum = true;
        input+='4';
        display();
    }

    public void input5(View view) {
        onscreen += "5";
        lastnum = true;
        input+='5';
        display();
    }

    public void input6(View view) {
        onscreen += "6";
        lastnum = true;
        input+='6';
        display();
    }

    public void input7(View view) {
        onscreen += "7";
        lastnum = true;
        input+='7';
        display();
    }

    public void input8(View view) {
        onscreen += "8";
        lastnum = true;
        input+='8';
        display();
    }

    public void input9(View view) {
        onscreen += "9";
        lastnum = true;
        input+='9';
        display();
    }

    public void inputplus(View view) {
        onscreen += "+";
        lastnum = false;
        input=onscreen;
        display();
    }

    public void inputsub(View view) {
        onscreen += "-";
        lastnum = false;
        input=onscreen;
        display();
    }

    public void inputdiv(View view) {
        onscreen += "/";
        lastnum = false;
        input=onscreen;
        display();
    }

    public void inputprod(View view) {
        onscreen += "*";
        lastnum = false;
        input=onscreen;
        display();
    }
    public void inputdec(View view) {
        onscreen += ".";
        lastnum = false;
        input=onscreen;
        display();
    }

    public void input0(View view) {
        onscreen += "0";
        lastnum = true;
        input+='0';
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

        if(input.length()==1)
        {
            T.setText(" "+input);
        }
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
        onscreen+=")";
        display();
       // System.out.println("length of exp is " + onscreen.length());
       for(int m=0;m<=onscreen.length();m++)
        {
           if(onscreen.charAt(m)==' ')
                continue;
            //System.out.println("here m is  " + m);
            if(onscreen.charAt(m)=='l'&&(onscreen.charAt(m+1)=='n')&&(onscreen.charAt(m+2)=='('))
            {
               //System.out.println("entered if at m = "+ m);
                m+=2;
                StringBuffer temp=new StringBuffer();
                while(onscreen.charAt(m+1)!=')')
                {
                    //System.out.println("inside while m is  "+ m  );
                    temp.append(onscreen.charAt(++m));
                    //System.out.println("temp buffer is " + temp.toString());
                }
                double res=Double.parseDouble(temp.toString());
                double rest;
                if(res<0)
                {
                    TextView text=(TextView)findViewById(R.id.input);
                    text.setText("Error");
                    break;
                }
                rest=Math.log(res);
                //System.out.println("Result of mathematical expression " + rest);
                //System.out.println("input  is "+ input);
                //System.out.println("input before "+ input);
                input=input.substring(0,input.length()-temp.length());
                //System.out.println("input after "+ input);
                input+=rest;
                //System.out.println("Input after after is " + input);
                onscreen=input;
                break;
            }
            if(onscreen.charAt(m)=='s'&&(onscreen.charAt(m+1)=='i')&&(onscreen.charAt(m+2)=='n')&&(onscreen.charAt(m+3)=='('))
            {
                //System.out.println("entered if at m = "+ m);
                m+=3;
                StringBuffer temp=new StringBuffer();
                while(onscreen.charAt(m+1)!=')')
                {
                    //System.out.println("inside while m is  "+ m  );
                    temp.append(onscreen.charAt(++m));
                    //System.out.println("temp buffer is " + temp.toString());
                }
                double res=Double.parseDouble(temp.toString());
                double rest=Math.toRadians(res);
                double eq=Math.sin(rest);
                //System.out.println("Result of mathematical expression " + rest);
                //System.out.println("input  is "+ input);
                //System.out.println("input before "+ input);
                input=input.substring(0,input.length()-temp.length());
                //System.out.println("input after "+ input);
                input+=eq;
                //System.out.println("Input after after is " + input);
                onscreen=input;
                break;
            }
            if(onscreen.charAt(m)=='c'&&(onscreen.charAt(m+1)=='o')&&(onscreen.charAt(m+2)=='s')&&(onscreen.charAt(m+3)=='('))
            {
                //System.out.println("entered if at m = "+ m);
                m+=3;
                StringBuffer temp=new StringBuffer();
                while(onscreen.charAt(m+1)!=')')
                {
                    //System.out.println("inside while m is  "+ m  );
                    temp.append(onscreen.charAt(++m));
                    //System.out.println("temp buffer is " + temp.toString());
                }
                double res=Double.parseDouble(temp.toString());
                double rest=Math.toRadians(res);
                double eq=Math.cos(rest);
                //System.out.println("Result of mathematical expression " + rest);
                //System.out.println("input  is "+ input);
                //System.out.println("input before "+ input);
                input=input.substring(0,input.length()-temp.length());
                //System.out.println("input after "+ input);
                input+=eq;
                //System.out.println("Input after after is " + input);
                onscreen=input;
                break;
            }
            if(onscreen.charAt(m)=='t'&&(onscreen.charAt(m+1)=='a')&&(onscreen.charAt(m+2)=='n')&&(onscreen.charAt(m+3)=='('))
            {
                m+=3;
                StringBuffer temp=new StringBuffer();
                while(onscreen.charAt(m+1)!=')')
                {
                    temp.append(onscreen.charAt(++m));
                }
                double res=Double.parseDouble(temp.toString());
                double rest=Math.toRadians(res);
                double eq=Math.tan(rest);
                input=input.substring(0,input.length()-temp.length());
                input+=eq;
                onscreen=input;
                break;
            }
            if(onscreen.charAt(m)=='s'&&(onscreen.charAt(m+1)=='i')&&(onscreen.charAt(m+2)=='n')&&(onscreen.charAt(m+3)=='h')&&(onscreen.charAt(m+4)=='('))
            {
                m+=4;
                StringBuffer temp=new StringBuffer();
                while(onscreen.charAt(m+1)!=')')
                {
                    temp.append(onscreen.charAt(++m));
                }
                double res=Double.parseDouble(temp.toString());
                double rest=Math.toRadians(res);
                double eq=Math.sinh(rest);
                input=input.substring(0,input.length()-temp.length());
                input+=eq;
                onscreen=input;
                break;
            }
            if(onscreen.charAt(m)=='c'&&(onscreen.charAt(m+1)=='o')&&(onscreen.charAt(m+2)=='s')&&(onscreen.charAt(m+3)=='h')&&(onscreen.charAt(m+4)=='('))
            {
                m+=4;
                StringBuffer temp=new StringBuffer();
                while(onscreen.charAt(m+1)!=')')
                {
                    temp.append(onscreen.charAt(++m));
                }
                double res=Double.parseDouble(temp.toString());
                double rest=Math.toRadians(res);
                double eq=Math.cosh(rest);
                input=input.substring(0,input.length()-temp.length());
                input+=eq;
                onscreen=input;
                break;
            }
            if(onscreen.charAt(m)=='t'&&(onscreen.charAt(m+1)=='a')&&(onscreen.charAt(m+2)=='n')&&(onscreen.charAt(m+3)=='h')&&(onscreen.charAt(m+4)=='('))
            {
                m+=4;
                StringBuffer temp=new StringBuffer();
                while(onscreen.charAt(m+1)!=')')
                {
                    temp.append(onscreen.charAt(++m));
                }
                double res=Double.parseDouble(temp.toString());
                double rest=Math.toRadians(res);
                double eq=Math.tanh(rest);
                input=input.substring(0,input.length()-temp.length());
                input+=eq;
                onscreen=input;
                break;
            }
            if(onscreen.charAt(m)=='s'&&(onscreen.charAt(m+1)=='q')&&(onscreen.charAt(m+2)=='r')&&(onscreen.charAt(m+3)=='t')&&(onscreen.charAt(m+4)=='('))
            {
                m+=4;
                StringBuffer temp=new StringBuffer();
                while(onscreen.charAt(m+1)!=')')
                {
                    temp.append(onscreen.charAt(++m));
                }
                double res=Double.parseDouble(temp.toString());
                double rest=Math.sqrt(res);
                input=input.substring(0,input.length()-temp.length());
                input+=rest;
                onscreen=input;
                break;
            }
            if(onscreen.charAt(m)=='f'&&(onscreen.charAt(m+1)=='l')&&(onscreen.charAt(m+2)=='o')&&(onscreen.charAt(m+3)=='o')&&(onscreen.charAt(m+4)=='r')&&(onscreen.charAt(m+5)=='('))
            {
                m+=5;
                StringBuffer temp=new StringBuffer();
                while(onscreen.charAt(m+1)!=')')
                {
                    temp.append(onscreen.charAt(++m));
                }
                double res=Double.parseDouble(temp.toString());
                if(res<0)
                {
                    TextView text=(TextView)findViewById(R.id.input);
                    text.setText("Error");
                    break;
                }
                double rest=Math.floor(res);
                input=input.substring(0,input.length()-temp.length());
                input+=rest;
                onscreen=input;
                break;
            }
            if(onscreen.charAt(m)=='c'&&(onscreen.charAt(m+1)=='e')&&(onscreen.charAt(m+2)=='i')&&(onscreen.charAt(m+3)=='l')&&(onscreen.charAt(m+4)=='('))
            {
                m+=4;
                StringBuffer temp=new StringBuffer();
                while(onscreen.charAt(m+1)!=')')
                {
                    temp.append(onscreen.charAt(++m));
                }
                double res=Double.parseDouble(temp.toString());
                if(res<0)
                {
                    TextView text=(TextView)findViewById(R.id.input);
                    text.setText("Error");
                    break;
                }
                double rest=Math.ceil(res);
                input=input.substring(0,input.length()-temp.length());
                input+=rest;
                onscreen=input;
                break;
            }
            if(onscreen.charAt(m)=='l'&&(onscreen.charAt(m+1)=='o')&&(onscreen.charAt(m+2)=='g')&&(onscreen.charAt(m+3)=='('))
            {
                m+=3;
                StringBuffer temp=new StringBuffer();
                while(onscreen.charAt(m+1)!=')')
                {
                    temp.append(onscreen.charAt(++m));
                }
                double res=Double.parseDouble(temp.toString());
                if(res<0)
                {
                   TextView text=(TextView)findViewById(R.id.input);
                    text.setText("Error");
                    break;
                }
                    double rest=Math.log10(res);
                input=input.substring(0,input.length()-temp.length());
                input+=rest;
                onscreen=input;
                break;
            }
        }
    }

    public void inputexpo(View view) {
        input+="^";
        onscreen=input;
        display();
    }

    public void inputln(View view) {

        onscreen+="ln(";
        //System.out.println("input is " + input);
        //System.out.println("Onscreen is "+ onscreen);
        display();
    }

    public void inputsin(View view) {
        onscreen+="sin(";
        display();
    }
    public void inputsinh(View view) {
        onscreen+="sinh(";
        display();
    }
    public void inputcos(View view) {
        onscreen+="cos(";
        display();
    }
    public void inputcosh(View view) {
        onscreen+="cosh(";
        display();
    }
    public void inputtan(View view) {
        onscreen+="tan(";
        display();
    }
    public void inputtanh(View view) {
        onscreen+="tanh(";
        display();
    }

    public void inputsqrt(View view) {
        onscreen+="sqrt(";
        display();
    }

    public void inputfloor(View view) {
        onscreen+="floor(";
        display();
    }

    public void inputceil(View view) {
        onscreen+="ceil(";
        display();
    }

    public void inputfact(View view) {
        onscreen+="!";
        display();
    }

    public void inputlog(View view) {
        onscreen+="log(";
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
            if ((op1 == '*' || op1 == '/' || op1=='^') && (op2 == '+' || op2 == '-'))
                return false;
            else
                return true;
        }
        public  double applyOp(char op, double b, double  a) {
            //System.out.println("entered ops metho");
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
                    //System.out.println(operands.peek());
                }
                //System.out.println("value of i after operand pushing statement"+ i);
                else if(s.charAt(i)=='(')
                {
                    //System.out.println("entered ( teest case ");
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
