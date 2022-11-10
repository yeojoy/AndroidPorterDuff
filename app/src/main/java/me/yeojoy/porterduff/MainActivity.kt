package me.yeojoy.porterduff

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

enum class MyPorterDuff(val porterDuffMode: PorterDuff.Mode, val title: String) {
    CLEAR(PorterDuff.Mode.CLEAR, "CLEAR"),
    SRC(PorterDuff.Mode.SRC, "SRC"),
    DST(PorterDuff.Mode.DST, "DST"),
    SRC_OVER(PorterDuff.Mode.SRC_OVER, "SRC_OVER"),
    DST_OVER(PorterDuff.Mode.DST_OVER, "DST_OVER"),
    SRC_IN(PorterDuff.Mode.SRC_IN, "SRC_IN"),
    DST_IN(PorterDuff.Mode.DST_IN, "DST_IN"),
    SRC_OUT(PorterDuff.Mode.SRC_OUT, "SRC_OUT"),
    DST_OUT(PorterDuff.Mode.DST_OUT, "DST_OUT"),
    SRC_ATOP(PorterDuff.Mode.SRC_ATOP, "SRC_ATOP"),
    DST_ATOP(PorterDuff.Mode.DST_ATOP, "DST_ATOP"),
    XOR(PorterDuff.Mode.XOR, "XOR"),
    DARKEN(PorterDuff.Mode.DARKEN, "DARKEN"),
    LIGHTEN(PorterDuff.Mode.LIGHTEN, "LIGHTEN"),
    MULTIPLY(PorterDuff.Mode.MULTIPLY, "MULTIPLY"),
    SCREEN(PorterDuff.Mode.SCREEN, "SCREEN"),
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = GridLayoutManager(this@MainActivity, 4)
            adapter = GridAdapter(MyPorterDuff.values())
            addItemDecoration(DividerItemDecoration(this@MainActivity, GridLayoutManager.HORIZONTAL))
            addItemDecoration(DividerItemDecoration(this@MainActivity, GridLayoutManager.VERTICAL))
        }
    }
}