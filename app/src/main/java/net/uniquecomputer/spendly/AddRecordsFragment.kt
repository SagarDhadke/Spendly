package net.uniquecomputer.spendly

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.view.LayoutInflater
import android.view.SurfaceControl.Transaction
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import net.uniquecomputer.spendly.databinding.FragmentAddRecordsBinding


class AddRecordsFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentAddRecordsBinding
    var transaction: Transaction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddRecordsBinding.inflate(layoutInflater, container, false)

        binding.incomeBtn.setOnClickListener { view ->
            binding.incomeBtn.background = requireContext().getDrawable(R.drawable.income_selector)
            binding.expenseBtn.background = requireContext().getDrawable(R.drawable.default_selector)
            binding.expenseBtn.setTextColor(requireContext().getColor(R.color.textColor))
            binding.incomeBtn.setTextColor(requireContext().getColor(R.color.greenColor))
//            transaction.setType(Constants.INCOME)
        }

        binding.expenseBtn.setOnClickListener { view ->
            binding.incomeBtn.background = requireContext().getDrawable(R.drawable.default_selector)
            binding.expenseBtn.background = requireContext().getDrawable(R.drawable.expense_selector)
            binding.incomeBtn.setTextColor(requireContext().getColor(R.color.textColor))
            binding.expenseBtn.setTextColor(requireContext().getColor(R.color.redColor))
//            transaction.setType(Constants.EXPENSE)
        }

        binding.date.setOnClickListener {
            val datePickerDialog = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                DatePickerDialog(requireContext())
            } else {
                TODO("VERSION.SDK_INT < N")
            }
            datePickerDialog.show()
        }

        return binding.root
    }


}