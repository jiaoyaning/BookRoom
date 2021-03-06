package com.jyn.bookroom.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.jyn.bookroom.R
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    companion object { //伴生对象,伴生对象在类中只能存在一个，类似于java中的静态方法 Java 中使用类访问静态成员，静态方法
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button_home.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_myFragment)
        }
    }
}
