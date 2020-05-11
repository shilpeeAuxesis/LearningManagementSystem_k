package com.learningmanagement.parent_account.myspace

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.learningmanagement.R
import com.learningmanagement.databinding.FragmentMySpaceParentBinding
import com.learningmanagement.parent_account.myspace.adapter.CustomTypeLevelAdapter
import kotlinx.android.synthetic.main.fragment_my_space_parent.view.*

class MySpaceParentFragment : Fragment()
{
    private lateinit var mySpaceParentViewModel : MySpaceParentViewModel
    lateinit var binding : FragmentMySpaceParentBinding

    var listDureation : ArrayList<String> =
        arrayListOf("Please select duration ","1 min", "2 min", "3 min", "4 min", "5 min", "6 min")

    override fun onCreateView(inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?) : View?
    {
        mySpaceParentViewModel = ViewModelProviders.of(this).get(MySpaceParentViewModel::class.java)
        binding = FragmentMySpaceParentBinding.inflate(inflater, container, false)
        val root = binding.root
        /*For cource spinner*/
        mySpaceParentViewModel.getTypeOfDuration()
        mySpaceParentViewModel.mName.observe(this, Observer {
            if (root.spinnerTypeOfLevel != null)
            {
                val adapter = CustomTypeLevelAdapter(context!!, it)
                root.spinnerTypeOfLevel.adapter = adapter
            }
            Log.d(">>>>>gg>>>>>", it.toString())
            if (root.spTypeOfLevelLess != null)
            {
                var adapter1 = CustomTypeLevelAdapter(context!!, it)
                root.spTypeOfLevelLess.adapter = adapter1
            }
        })

        root.spinnerTypeOfLevel.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener
            {
                override fun onNothingSelected(parent : AdapterView<*>?)
                {
                }

                override fun onItemSelected(parent : AdapterView<*>?,
                    view : View?,
                    position : Int,
                    id : Long)
                {
                    Log.d(">>>>>>>>", position.toString())
                }
            }
        /*For lession Spinner*/
        root.spTypeOfLevelLess.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener
            {
                override fun onNothingSelected(parent : AdapterView<*>?)
                {
                }

                override fun onItemSelected(
                    parent : AdapterView<*>?,
                    view : View?,
                    position : Int,
                    id : Long
                )
                {
                    Log.d(">>>>>>>><<<<<", position.toString())
                }
            }

        if (root.spinnerDuration != null)
        {
            val adapter3 = CustomTypeLevelAdapter(context!!, listDureation)
            root.spinnerDuration.adapter = adapter3
        }

        if (root.spDurationLess != null)
        {
            val adapter4 = CustomTypeLevelAdapter(context!!, listDureation)
            root.spDurationLess.adapter = adapter4
        }

        return root
    }
}