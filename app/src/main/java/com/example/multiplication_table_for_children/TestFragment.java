package com.example.multiplication_table_for_children;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class TestFragment extends Fragment {
   // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "number";
    private static final String ARG_PARAM2 = "count";
    private static final String ARG_PARAM3 = "goodAnswer";

    // TODO: Rename and change types of parameters
    private int number;
    private int count;
    private int goodAnswer;

    public TestFragment() {
        // Required empty public constructor
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TestFragment.
     */
    // TODO: Rename and change types and number of parameters


    public static TestFragment newInstance(int number, int count, int goodAnswer) {
        TestFragment fragment = new TestFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, number);
        args.putInt(ARG_PARAM2, count);
        args.putInt(ARG_PARAM3, goodAnswer);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            number = getArguments().getInt(ARG_PARAM1);
            count = getArguments().getInt(ARG_PARAM2);
            goodAnswer = getArguments().getInt(ARG_PARAM3);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
                View view = inflater.inflate(R.layout.fragment_test,container,false);
                TextView primer = (TextView) view.findViewById(R.id.primerTextView);
                primer.setText("" + number + " X " + count + " =");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView primerTextView = view.findViewById(R.id.primerTextView);
        EditText editTextAnswer = view.findViewById(R.id.editTextNumberSigned);
        editTextAnswer.setTextColor(getResources().getColor(R.color.red));
        TextView textView1 = view.findViewById(R.id.textView1);
        Button buttonAnswer = view.findViewById(R.id.buttonAnswer);
        ImageView imageTest = view.findViewById(R.id.imageTest);
        number = getArguments().getInt(ARG_PARAM1);


         buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextAnswer.setTextColor(getResources().getColor(R.color.red));
                int good = number * count;
                String editAnswer;
                if (editTextAnswer.getText().toString().equals("")) editAnswer = "0"; // проверяем пустой ввод
                else editAnswer = editTextAnswer.getText().toString();
                int userAnswer = Integer.parseInt(editAnswer);

                if (count == 10) {
                    if (good == userAnswer) {
                        Toast toast = Toast.makeText(requireContext().getApplicationContext(), "Верно!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0,0);
                        toast.show();
                        goodAnswer++;
                    } else {Toast toast = Toast.makeText(requireContext().getApplicationContext(),"Ошибка!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0,0);
                        toast.show();

                    }
                    textView1.setText("Тест завершен ");
                    if (goodAnswer == 10 ){
                        imageTest.setImageResource(R.drawable.testverygood);
                        primerTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.testEnd));
                        primerTextView.setText("МОЛОДЕЦ!\n ТВОЯ ОЦЕНКА :");
                        editTextAnswer.setText("5");
                        editTextAnswer.setEnabled(false);
                    } else if (goodAnswer >= 8 ){
                        imageTest.setImageResource(R.drawable.testgood);
                        primerTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.testEnd));
                        primerTextView.setText("ЕСТЬ ОШИБКИ!\n ТВОЯ ОЦЕНКА :");
                        editTextAnswer.setText("4");
                        editTextAnswer.setEnabled(false);
                    } else if (goodAnswer >= 6 ) {
                        imageTest.setImageResource(R.drawable.testbad);
                        primerTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.testEnd));
                        primerTextView.setText("МНОГО ОШИБОК!\n ТВОЯ ОЦЕНКА :");
                        editTextAnswer.setText("3");
                        editTextAnswer.setEnabled(false);
                    }else  {
                        imageTest.setImageResource(R.drawable.testbad);
                        primerTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.testEnd));
                        primerTextView.setText(" ОЧЕНЬ МНОГО ОШИБОК!\n ТВОЯ ОЦЕНКА :");
                        editTextAnswer.setText("2");
                        editTextAnswer.setEnabled(false);
                    }
                    buttonAnswer.setText("Главная страница");
                    buttonAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            getParentFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new FragmentTop()).commit();
                        }
                    });
                }
                    else {
                        if (good == userAnswer && count != 10) {
                        Toast toast = Toast.makeText(requireContext().getApplicationContext(),"Верно!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0,0);
                        toast.show();
                        goodAnswer++;
                        count++;
                        } else {
                            Toast toast = Toast.makeText(requireContext().getApplicationContext(),"Ошибка!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0,0);
                            toast.show();
                            count++;
                        }
                        primerTextView.setText(" " + number + " x " + count + " = ");
                        editTextAnswer.setText("");
                    }
            }
        });


    }



}