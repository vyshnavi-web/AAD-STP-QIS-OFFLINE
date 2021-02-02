package in.ac.khitguntur.phase1_praticals;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DBActivity extends AppCompatActivity
{
EditText u,a;
DbHelper dbHelper;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        u=findViewById(R.id.name11);
        a=findViewById(R.id.age);
        tv=findViewById(R.id.results);
        dbHelper=new DbHelper(this);
    }

    public void saveData(View view)
    {
        String uu=u.getText().toString();
        int aa=Integer.parseInt(a.getText().toString());
        ContentValues cv=new ContentValues();
        cv.put(dbHelper.col_1,uu);
        cv.put(dbHelper.col_2,aa);
        long l=dbHelper.saveDataValues(cv);
        Toast.makeText(this, "Row affected : "+l, Toast.LENGTH_SHORT).show();
    }

    public void retrieveData(View view)
    {
        StringBuilder builder=new StringBuilder();
        Cursor c=dbHelper.retriveData();
        while (c.moveToNext()){
            builder.append(c.getString(1)+"\t");
            builder.append(c.getString(2)+"\n");
        }
        tv.setText(builder);
    }

    public void updateData(View view) {
     //   dbHelper.updateData();
    }

    public void deleteData(View view) {
    }
}
