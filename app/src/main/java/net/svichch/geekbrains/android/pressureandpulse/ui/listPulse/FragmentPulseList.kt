package net.svichch.geekbrains.android.pressureandpulse.ui.listPulse

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.svichch.geekbrains.android.pressureandpulse.R
import net.svichch.geekbrains.android.pressureandpulse.databinding.FragmentPulseListBinding
import net.svichch.geekbrains.android.pressureandpulse.ui.MainActivity
import net.svichch.geekbrains.android.pressureandpulse.ui.addPage.FragmentAddPulse

class FragmentPulseList : Fragment() {

    private var columnCount = 1
    private lateinit var fragment: FragmentPulseListBinding
    private lateinit var adapter: PulseViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragment = FragmentPulseListBinding.inflate(inflater, container, false)
        fragment.list.layoutManager = GridLayoutManager(context, columnCount)
        addAdapter()
        setupFab()
        return fragment.root
    }

    private fun setupFab() {
        fragment.fab.setOnClickListener {
            toFragmentAddPulse()
        }
        fabOffOnScroll()
    }

    // Скрывать Fab при scroll
    private fun fabOffOnScroll() {
        fragment.list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && fragment.fab.visibility === View.VISIBLE) {
                    fragment.fab.hide()
                } else if (dy < 0 && fragment.fab.visibility !== View.VISIBLE) {
                    fragment.fab.show()
                }
            }
        })
    }

    private fun addAdapter() {
        adapter = PulseViewAdapter()
        fragment.list.adapter = adapter
        addLine(fragment.list)
    }

    // Добавляем полоску
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun addLine(list: RecyclerView) {
        val dividerItemDecoration = DividerItemDecoration(this.context, RecyclerView.VERTICAL)
        dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.divider_line, null))
        list.addItemDecoration(dividerItemDecoration)
    }

    // Переход на фрагмент информации о фильме
    fun toFragmentAddPulse() {
        (requireActivity() as MainActivity).navigateTo(
            FragmentAddPulse.newInstance()
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentPulseList()
    }
}