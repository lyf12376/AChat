package com.example.roomtest.nav.login


import androidx.lifecycle.ViewModel
import com.example.roomtest.room.savedUser.SavedUser
import com.example.roomtest.room.savedUser.SavedUserDao
import com.example.roomtest.room.users.UsersDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    savedUserDao: SavedUserDao,
    usersDao: UsersDao
) : ViewModel() {

    private val loginRepository = LoginRepository(savedUserDao, usersDao)
    val savedUserList: Flow<List<SavedUser>> = loginRepository.getSavedUserList()

    fun saveUsers(savedUser: SavedUser) {
        loginRepository.saveUser(savedUser)
    }

    fun deleteSavedUser(account: String) {
        loginRepository.deleteUser(account)
    }

    suspend fun isLogin(account: String, password: String): Boolean {
        return loginRepository.isLogin(account,password)
    }

}
