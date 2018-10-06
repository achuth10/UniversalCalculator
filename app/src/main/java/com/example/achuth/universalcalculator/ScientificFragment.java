package com.example.achuth.universalcalculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScientificFragment extends Fragment {
    String input = " ",display=" ",onscreen=" ";
    boolean lastnum = false;
    TextView T,text;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,ba,bs,bm,bd,bbrackopen,bbrackclose,buttonexpo,buttoneval,buttondecimal;
    Button sin,cos,tan,sinh,cosh,tanh,floor,ceil,log10,ln,fact,sqrt;

    public ScientificFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_scientific, container, false);
        Button delete= v.findViewById(R.id.delete);
        T = v.findViewById(R.id.input);
        text= v.findViewById(R.id.input);
        b1= v.findViewById(R.id.button1);
        b2= v.findViewById(R.id.button2);
        b3= v.findViewById(R.id.button3);
        b4= v.findViewById(R.id.button4);
        b5= v.findViewById(R.id.button5);
        b6= v.findViewById(R.id.button6);
        b7= v.findViewById(R.id.button7);
        b8= v.findViewById(R.id.button8);
        b9= v.findViewById(R.id.button9);
        b0= v.findViewById(R.id.button0);
        ba= v.findViewById(R.id.buttonadd);
        bd= v.findViewById(R.id.buttondiv);
        bm= v.findViewById(R.id.buttonmultiply);
        bs= v.findViewById(R.id.buttonsub);
        bbrackopen= v.findViewById(R.id.buttonbracketopen);
        bbrackclose= v.findViewById(R.id.buttonbracketclose);
        buttoneval= v.findViewById(R.id.buttonequal);
        buttonexpo= v.findViewById(R.id.buttonexpo);
        buttondecimal= v.findViewById(R.id.buttondecimal);


        sin= v.findViewById(R.id.buttonsin);
        sinh= v.findViewById(R.id.buttonsinh);
        cos= v.findViewById(R.id.buttoncos);
        cosh= v.findViewById(R.id.buttoncosh);
        tan= v.findViewById(R.id.buttontan);
        tanh= v.findViewById(R.id.buttontanh);
        ceil= v.findViewById(R.id.buttonceil);
        floor= v.findViewById(R.id.buttonfloor);
        log10= v.findViewById(R.id.buttonlog);
        ln= v.findViewById(R.id.buttonln);
        fact = v.findViewById(R.id.buttonfact);
        sqrt= v.findViewById(R.id.buttonsqrt);

        delete.setOnLongClickListener(new View.OnLongClickListener() {
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

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen += "1";
                lastnum = true;
                input+='1';
                display();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen += "2";
                lastnum = true;
                input+='2';
                display();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen += "3";
                lastnum = true;
                input+='3';
                display();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen += "4";
                lastnum = true;
                input+='4';
                display();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen += "5";
                lastnum = true;
                input+='5';
                display();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen += "6";
                lastnum = true;
                input+='6';
                display();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen += "7";
                lastnum = true;
                input+='7';
                display();
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen += "8";
                lastnum = true;
                input+='8';
                display();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen += "9";
                lastnum = true;
                input+='9';
                display();
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen += "0";
                lastnum = true;
                input+='0';
                display();
            }
        });
        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen += "+";
                lastnum = false;
                input=onscreen;
                display();
            }
        });
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen += "/";
                lastnum = false;
                input=onscreen;
                display();
            }
        });
        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen += "*";
                lastnum = false;
                input=onscreen;
                display();
            }
        });
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen += "-";
                lastnum = false;
                input=onscreen;
                display();
            }
        });
        buttondecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen += ".";
                lastnum = false;
                input=onscreen;
                display();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.length() >= 1) {
                    input = input.substring(0, input.length() - 1);
                    onscreen=input;
                    display();
                } else {
                    input = " ";
                    onscreen=input;
                    lastnum = false;
                }
            }
        });
        buttoneval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input==" "|| lastnum==false)
                {
                    T.setText("Error");
                    input=" ";
                    onscreen=input;

                }
                else {
                    boolean check = true;
                    working W = new working();
                    for (int i = 1; i < input.length(); i++) {
                        if (W.isOperand(input.charAt(i))) {
                            if (!check(input.charAt(i - 1))) {
                                T.setText("Error");
                                check = false;
                                break;
                            }
                        }
                    }
                    if (check) {
                        double result = W.driver(input);
                        T.setText(" " + result);
                        input = " " + result;
                        onscreen = input;
                    }
                }

            }
        });

        bbrackopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="(";
                onscreen=input;
                display();
            }
        });
        bbrackclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen+=")";
                display();
                working W=new working();
                for(int m=0;m<=onscreen.length();m++)
                {
                    if(onscreen.charAt(m)==' ')
                        continue;
                    if(onscreen.charAt(m)=='('&&onscreen.charAt(m+1)==')')
                    {
                        input=" ";
                        onscreen=" ";
                        text.setText("Error");
                        break;
                    }
                    if(onscreen.charAt(m)=='l'&&(onscreen.charAt(m+1)=='n')&&(onscreen.charAt(m+2)=='('))
                    {
                        m+=2;
                        StringBuffer temp=new StringBuffer();
                        while(onscreen.charAt(m+1)!=')')
                        {
                            temp.append(onscreen.charAt(++m));
                        }
                        double res=W.driver(temp.toString());
                        double rest;
                        if(res<0)
                        {
                            input=" ";
                            onscreen=" ";
                            text.setText("Error");
                            break;
                        }
                        rest=Math.log(res);
                        input=input.substring(0,input.length()-temp.length());
                        input+=rest;
                        onscreen=input;
                        break;
                    }
                    if(onscreen.charAt(m)=='s'&&(onscreen.charAt(m+1)=='i')&&(onscreen.charAt(m+2)=='n')&&(onscreen.charAt(m+3)=='('))
                    {
                        m+=3;
                        StringBuffer temp=new StringBuffer();
                        while(onscreen.charAt(m+1)!=')')
                        {
                            temp.append(onscreen.charAt(++m));
                        }
                        double res=W.driver(temp.toString());
                        double rest=Math.toRadians(res);
                        double eq=Math.sin(rest);
                        input=input.substring(0,input.length()-temp.length());
                        input+=eq;
                        onscreen=input;
                        break;
                    }
                    if(onscreen.charAt(m)=='c'&&(onscreen.charAt(m+1)=='o')&&(onscreen.charAt(m+2)=='s')&&(onscreen.charAt(m+3)=='('))
                    {
                        m+=3;
                        StringBuffer temp=new StringBuffer();
                        while(onscreen.charAt(m+1)!=')')
                        {
                            temp.append(onscreen.charAt(++m));
                        }
                        double res=W.driver(temp.toString());
                        double rest=Math.toRadians(res);
                        double eq=Math.cos(rest);
                        input=input.substring(0,input.length()-temp.length());
                        input+=eq;
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
                        double res=W.driver(temp.toString());
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
                        double res=W.driver(temp.toString());
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
                        double res=W.driver(temp.toString());
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
                        double res=W.driver(temp.toString());
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
                        double res=W.driver(temp.toString());
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
                        double res=W.driver(temp.toString());
                        if(res<0)
                        {
                            input=" ";
                            onscreen=" ";
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
                        double res=W.driver(temp.toString());
                        if(res<0)
                        {
                            input=" ";
                            onscreen=" ";
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
                        double res=W.driver(temp.toString());
                        if(res<0)
                        {
                            input=" ";
                            onscreen=" ";
                            text.setText("Error");
                            break;
                        }
                        double rest=Math.log10(res);
                        input=input.substring(0,input.length()-temp.length());
                        input+=rest;
                        onscreen=input;
                        break;
                    }
                    else if(onscreen.charAt(m)=='(' )
                    {
                        if (onscreen.charAt(m + 1) != 'l' || onscreen.charAt(m - 1) != 's' || onscreen.charAt(m - 1) != 'c' || onscreen.charAt(m - 1) != 't' || onscreen.charAt(m - 1) != 'f') {
                            input += ")";
                            onscreen = input;
                            display();
                            break;
                        }
                    }
                    else if(onscreen.charAt(m)==')' && onscreen.charAt(m-1)!='(' )
                    {
                        text.setText("Error");
                        break;
                    }
                }
                }

        });
        buttonexpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="^";
                onscreen=input;
                display();
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen+="sin(";
                display();
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen+="cos(";
                display();
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen+="tan(";
                display();
            }
        });
        sinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen+="sinh(";
                display();
            }
        });
        cosh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen+="cosh(";
                display();
            }
        });
        tanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen+="tanh(";
                display();
            }
        });
        ceil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen+="ceil(";
                display();
            }
        });
        floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen+="floor(";
                display();
            }
        });
        fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen+="!";
                input=onscreen;
                StringBuffer tempp = new StringBuffer();
                double tempnum=0;
                for(int i=1;i<input.length();i++) {

                    if (input.charAt(i) == '!') {
                        while (check(input.charAt(i - 1)) && i != 0) {

                            tempp.append(input.charAt(i - 1));
                            i--;
                        }
                        tempp.reverse();
                        tempnum = Double.parseDouble(tempp.toString());
                        tempnum = factorial(tempnum);
                        input = input.substring(0, input.length() - tempp.length()-1);
                        input += tempnum;
                        onscreen=input;
                        break;
                    }
                }
                display();
            }
        });
        log10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen+="log(";
                display();
            }
        });
        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen+="ln(";
                display();
            }
        });
        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onscreen+="sqrt(";
                display();
            }
        });

        // Inflate the layout for this fragment
        return v;

    }
    public void display() {
        T.setText(" " + onscreen);
    }
    public double factorial(double n)
    {
        double r = n - Math.floor(n) + 1;
        for (;n>1; n-=1) {
            r *= n;
        }
        return r;
        /*return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);*/

    }
    public boolean  check(char c)
    {
        switch (c)
        {
            case  '1':
            case  '2':
            case  '3':
            case  '4':
            case  '5':
            case  '6':
            case  '7':
            case  '8':
            case  '9':
            case '.':
            case  '0':return true;
            default:return false;

        }
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
                    TextView t= getView().findViewById(R.id.input);
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
