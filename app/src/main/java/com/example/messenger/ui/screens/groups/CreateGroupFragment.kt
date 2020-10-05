package com.example.messenger.ui.screens.groups

import androidx.recyclerview.widget.RecyclerView
import com.example.messenger.R
import com.example.messenger.models.CommonModel
import com.example.messenger.ui.screens.base.BaseFragment
import com.example.messenger.utilits.APP_ACTIVITY
import com.example.messenger.utilits.hideKeyboard
import com.example.messenger.utilits.showToast
import kotlinx.android.synthetic.main.add_contacts.*
import kotlinx.android.synthetic.main.fragment_create_group.*

class CreateGroupFragment(private var listContacts: List<CommonModel>) :
    BaseFragment(R.layout.fragment_create_group) {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: AddContactsAdapter

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Создать группу"
        APP_ACTIVITY.mAppDrawer.enableDrawer()
        hideKeyboard()
        initRecyclerView()
        create_group_btn_complete.setOnClickListener { showToast("Click") }
        create_group_input_name.requestFocus()
    }

    private fun initRecyclerView() {
        mRecyclerView = create_group_recycler_view
        mAdapter = AddContactsAdapter()
        mRecyclerView.adapter = mAdapter
        listContacts.forEach { mAdapter.updateListItems(it) }
    }
}