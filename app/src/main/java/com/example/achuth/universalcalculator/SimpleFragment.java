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
public class SimpleFragment extends Fragment {
    String input = " ",onscreen=" ";
    boolean lastnum,dec;
    TextView T;
    TextView text;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,ba,bs,bm,bd,bbrackopen,bbrackclose,buttonexpo,buttoneval,buttondecimal;

    public SimpleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_simple, container, false);
        Button delete= v.findViewById(R.id.delete);
        T = v.findViewById(R.id.input);
        text= v.findViewById(R.id.input);
        dec=lastnum=false;
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

        delete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub

                input=" ";
                onscreen=input;
                display();
                lastnum=false;dec=false;
                return true;
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "1";
                onscreen=input;
                lastnum = true;
                display();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "2";
                lastnum = true;
                onscreen=input;
                display();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "3";
                lastnum = true;
                onscreen=input;
                display();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "4";
                lastnum = true;
                onscreen=input;
                display();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "5";
                lastnum = true;
                onscreen=input;
                display();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "6";
                lastnum = true;
                onscreen=input;
                display();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "7";
                lastnum = true;
                onscreen=input;
                display();
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "8";
                lastnum = true;
                onscreen=input;
                display();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "9";
                lastnum = true;
                onscreen=input;
                display();
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "0";
                lastnum = true;
                onscreen=input;
                display();
            }
        });
        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "+";
                lastnum = false;
                onscreen=input;
                display();
            }
        });
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "/";
                lastnum = false;
                onscreen=input;
                display();
            }
        });
        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "*";
                lastnum = false;
                onscreen=input;
                display();
            }
        });
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "-";
                lastnum = false;
                onscreen=input;
                display();
            }
        });
        buttondecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dec) {
                    onscreen += ".";
                    lastnum = false;
                    input = onscreen;
                    display();
                    dec=true;
                }

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.length() >= 1) {
                    if(input.charAt(input.length()-1)=='.')
                        dec=false;
                    input = input.substring(0, input.length() - 1);
                    onscreen=input;
                    display();
                } else {
                    input = "0";
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
                        Log.i("inside for and i = ", " " + i);

                        if (W.isOperand(input.charAt(i))) {
                            if (!check(input.charAt(i - 1))) {
                                T.setText("Error");
                                check = false;
                                break;
                            }
                        }
                        if(input.charAt(i)=='('&&!W.isOperand(input.charAt(i-1)))
                        {
                            String s=input.substring(i,input.length());
                            String b =input.substring(0,i);
                            input= b+'*'+s;
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
                input+=")";
                onscreen=input;
                display();
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
        });
        buttonexpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="^";
                onscreen=input;
                display();
            }
        });
        // Inflate the layout for this fragment
        return v;

    }


    public void display() {
        T.setText(" " + onscreen);
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
