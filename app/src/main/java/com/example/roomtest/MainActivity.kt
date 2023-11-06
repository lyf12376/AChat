package com.example.roomtest

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.view.WindowCompat
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.roomtest.customizeComposable.animation.EnterAnimation
import com.example.roomtest.customizeComposable.page.Loading
import com.example.roomtest.nav.chatList.HomePage
import com.example.roomtest.nav.chatPage.chatPage
import com.example.roomtest.nav.login.Login
import com.example.roomtest.nav.navigation_graph.NavigationGraph.basicMessageRoute
import com.example.roomtest.nav.navigation_graph.NavigationGraph.chatRoute
import com.example.roomtest.nav.navigation_graph.NavigationGraph.loginRoute
import com.example.roomtest.nav.navigation_graph.NavigationGraph.registerRoute
import com.example.roomtest.nav.register.BasicMessage
import com.example.roomtest.nav.register.Register
import com.example.roomtest.room.chatRecord.ChatRecord
import com.example.roomtest.room.chatRecord.ChatRecordDatabase
import com.example.roomtest.room.savedUser.SavedUser
import com.example.roomtest.room.users.UsersDatabase
import com.example.roomtest.utils.DateUtils
import com.example.roomtest.utils.TransparentSystemBars
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val scope1 = CoroutineScope(Dispatchers.IO)

    private lateinit var chatList: List<String>
    private val isLoaded = mutableStateOf(true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val usersDatabase = UsersDatabase.getDatabase(this)
        val usersDao = usersDatabase.usersDao()

        val chatDatabase = ChatRecordDatabase.getDatabase(this)
        val chatRecordDao = chatDatabase.chatRecordDao()

        var savedUserList : List<SavedUser> = mutableListOf()

        val chatRecord =
            ChatRecord(
                sender = "lyf",
                receiver = "lyf",
                message = "你好年后",
                time = DateUtils.getCurrentTime()
            )

        scope1.launch {
                chatRecordDao.insertRecord(chatRecord)
                chatRecordDao.deleteAll()
                chatList = getChatList(context = this@MainActivity)
                delay(2000)
                isLoaded.value = false
        }


        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            TransparentSystemBars()
            val isLoading by remember { isLoaded }
            val navController = rememberNavController()
            if (isLoading) {
                Loading()
            } else {
                    NavHost(navController, startDestination = "login") {
                        composable(loginRoute) {
                            EnterAnimation {
                                Login(navController)
                            }
                        }
                        composable("main") { HomePage(navController, chatList) }
                        composable(registerRoute) {
                            EnterAnimation {
                                Register(navController, usersDao)
                            }
                        }
                        composable(
                            basicMessageRoute,
                            arguments = listOf(
                                navArgument("account") { type = NavType.StringType },
                            ),
                        ) { backStackEntry ->
                            val account = backStackEntry.arguments?.getString("account")
                            EnterAnimation{
                                BasicMessage(account!!,navController, usersDao)
                            }
                        }
                        composable(
                            chatRoute,
                            arguments = listOf(
                                navArgument("senderName") { type = NavType.StringType },
                                navArgument("peopleNum") { type = NavType.IntType }
                            ),
                        ) { backStackEntry ->
                            val senderName = backStackEntry.arguments?.getString("senderName")
                            val peopleNum = backStackEntry.arguments?.getInt("peopleNum")
                            chatPage(navController,senderName = senderName!!, peopleNum = peopleNum!!)
                        }
                    }

                }
            }

        }
    }

suspend fun getChatList(context: Context):List<String>
{
    val chatDatabase = ChatRecordDatabase.getDatabase(context)
    val chatRecordDao = chatDatabase.chatRecordDao()

    return chatRecordDao.messageList()

}





