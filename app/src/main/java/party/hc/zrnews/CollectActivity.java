package party.hc.zrnews;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import party.hc.zrnews.UI.ICallBack;
import party.hc.zrnews.UI.RecordSQLiteOpenHelper;
import party.hc.zrnews.UI.SearchListView;
import party.hc.zrnews.UI.bCallBack;

public class CollectActivity extends AppCompatActivity {
    private EditText edit_search;
    private LinearLayout search_block;
    private ImageView searchBack;
    private SearchListView listView;
    private ICallBack mCallBack;
    private bCallBack nCallBack;
    private BaseAdapter adapter;
    private TextView tv_clear;
    private RecordSQLiteOpenHelper dbHelper;
    private SQLiteDatabase db;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        back= (Button) findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        edit_search= (EditText) findViewById(R.id.edit_search);
        listView= (SearchListView) findViewById(R.id.listView);
        tv_clear= (TextView) findViewById(R.id.tv_clear);
        tv_clear.setVisibility(View.INVISIBLE);
        dbHelper=new RecordSQLiteOpenHelper(getApplicationContext());
        tv_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteDta();
                queryData("");
            }
        });
        edit_search.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent event) {
                if(i==KeyEvent.KEYCODE_ENTER && event.getAction()==KeyEvent.ACTION_DOWN){
                    if(!(mCallBack==null)){
                        mCallBack.SearchAction(edit_search.getText().toString());
                    }

                    Toast.makeText(getApplicationContext(),"搜索内容为"+edit_search.getText(),Toast.LENGTH_SHORT).show();

                    boolean hasData=hasData(edit_search.getText().toString().trim());
                    if(!hasData){
                        insetData(edit_search.getText().toString().trim());
                        queryData("");
                    }
                }

                return false;
            }
        });
        edit_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String tempName=edit_search.getText().toString();
                queryData(tempName);
            }
        });
    }

    private void deleteDta() {
        db=dbHelper.getReadableDatabase();
        db.execSQL("delete from records");
        db.close();
        tv_clear.setVisibility(View.INVISIBLE);
    }

    private void insetData(String tempName) {
        db=dbHelper.getReadableDatabase();
        db.execSQL("insert into records(name) values('" + tempName + "')");
        db.close();
    }

    private boolean hasData(String tempName) {
        Cursor cursor=dbHelper.getReadableDatabase().rawQuery("select id as _id,name from records where name =?", new String[]{tempName});
        return cursor.moveToNext();
    }

    private void queryData(String tempName) {
        Cursor cursor=dbHelper.getReadableDatabase().rawQuery("select id as _id,name from records where name like '%" + tempName + "%' order by id desc ", null);
        adapter=new SimpleCursorAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,cursor,new String[]{"name"},new int[]{android.R.id.text1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        if(tempName.equals("")&&cursor.getCount()!=0){
            tv_clear.setVisibility(View.VISIBLE);
        }
        else {
            tv_clear.setVisibility(View.INVISIBLE);
        }
    }
}
