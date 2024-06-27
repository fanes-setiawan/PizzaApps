package com.example.pizzaapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzaapp.adapter.TransactionAdapter
import com.example.pizzaapp.databinding.FragmentTransactionBinding
import com.example.pizzaapp.model.Transaction

class TransactionFragment : Fragment() {

    private lateinit var binding: FragmentTransactionBinding
    private val transactionAdapter = TransactionAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvTransactions.layoutManager = LinearLayoutManager(context)
        binding.rvTransactions.adapter = transactionAdapter

        displayData()
    }

    private fun displayData() {
        val transactionList = listOf(
            Transaction(1, 10000.0, 500.0, 10500.0),
            // Add other transactions
        )
        transactionAdapter.setTransactionList(transactionList)
    }
}
