package com.xrigau.nytimesmostpopular;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.xrigau.nytimesmostpopular.dummy.DummyContent;

import android.os.Bundle;

public class ArticleListActivity extends AppCompatActivity {

    private boolean showDetailPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        if (findViewById(R.id.item_detail_container) != null) {
            showDetailPane = true;
        }

        RecyclerView recyclerView = findViewById(R.id.item_list);
        recyclerView.setAdapter(new ArticleAdapter(this, DummyContent.ITEMS, showDetailPane));
    }

}
