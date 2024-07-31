package com.serdar.inappcampaign_sdui_websocket.util

import androidx.compose.ui.Alignment


fun position(position:String):Alignment{
   return when(position){
        "TopCenter"->{
            Alignment.TopCenter
        }
        "BottomCenter"->{
            Alignment.BottomCenter
        }
        "Center"->{
            Alignment.Center

        }
       "TopEnd"->{
           Alignment.TopEnd

       }
       "CenterStart"->{
           Alignment.CenterStart

       }

       else -> {Alignment.Center}
   }
}