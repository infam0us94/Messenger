package com.example.messenger.ui.screens.message_recycler_view.view_holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.messenger.database.CURRENT_UID
import com.example.messenger.ui.screens.message_recycler_view.views.MessageView
import com.example.messenger.utilits.asTime
import com.example.messenger.utilits.downloadAndSetImage
import kotlinx.android.synthetic.main.message_item_image.view.*
import kotlinx.android.synthetic.main.message_item_text.view.*

class HolderImageMessage(view: View) : RecyclerView.ViewHolder(view), MessageHolder {
    private val blocReceivedImageMassage: ConstraintLayout = view.bloc_received_image
    private val blocUserImageMessage: ConstraintLayout = view.bloc_user_message
    private val chatUserImage: ImageView = view.chat_user_image
    private val chatReceivedImage: ImageView = view.chat_user_received_image
    private val chatUserImageMessageTime: TextView = view.chat_user_image_time
    private val chatReceivedImageMessageTime: TextView = view.chat_received_image_time

    override fun drawMessage(view: MessageView) {
        if (view.from == CURRENT_UID) {
            blocReceivedImageMassage.visibility = View.GONE
            blocUserImageMessage.visibility = View.VISIBLE
            chatUserImage.downloadAndSetImage(view.fileUrl)
            chatUserImageMessageTime.text =
                view.timeStamp.asTime()
        } else {
            blocReceivedImageMassage.visibility = View.VISIBLE
            blocUserImageMessage.visibility = View.GONE
            chatReceivedImage.downloadAndSetImage(view.fileUrl)
            chatReceivedImageMessageTime.text =
                view.timeStamp.asTime()
        }
    }

    override fun onAttach(view: MessageView) {
    }

    override fun onDetach() {
    }
}