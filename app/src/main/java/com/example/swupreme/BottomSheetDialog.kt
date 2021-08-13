package com.example.swupreme

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.daycheck.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetDialog : BottomSheetDialogFragment() {
    lateinit var bottomSheetButtonClickListener: BottomSheetButtonClickListener
    lateinit var imageButton1: ImageButton
    lateinit var imageButton2: ImageButton
    lateinit var imageButton3: ImageButton
    lateinit var imageButton4: ImageButton
    lateinit var imageButton5: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.modal_bottom_sheet_layout,container,false)
        return view
    }

    interface BottomSheetButtonClickListener{
        fun onButtonClicked(text: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            bottomSheetButtonClickListener = context as BottomSheetButtonClickListener
        } catch (e: ClassCastException) {
            Log.d("bottom", "onAttach error")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imageButton1.setOnClickListener {
            bottomSheetButtonClickListener.onButtonClicked("최고에요")
            dismiss()
        }
        imageButton2.setOnClickListener {
            bottomSheetButtonClickListener.onButtonClicked("좋아요")
            dismiss()
        }
        imageButton3.setOnClickListener {
            bottomSheetButtonClickListener.onButtonClicked("보통이에요")
            dismiss()
        }
        imageButton4.setOnClickListener {
            bottomSheetButtonClickListener.onButtonClicked("안좋아요")
            dismiss()
        }
        imageButton5.setOnClickListener {
            bottomSheetButtonClickListener.onButtonClicked("최악이에요")
            dismiss()
        }
    }
}
