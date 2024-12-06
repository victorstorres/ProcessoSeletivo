package com.example.processo_seletivo

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.processo_seletivo.navigation.ShopperNavHost
import org.junit.Before
import org.junit.Rule
import org.junit.Test

private const val NAME = "Shooper"

class SplashScreenTest {

    @get: Rule
    val rule = createComposeRule()
    lateinit var navController: TestNavHostController


    @Before
    fun setUp() {
        rule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            ShopperNavHost(navController = navController)
        }
    }

    @Test
    fun should_show_name_app() {
        rule.onNodeWithText(NAME).assertExists()
    }

    @Test
    fun should_not_show_name_app_after_change_screen() {
        rule.onNodeWithText(NAME).assertExists()
        rule.waitUntil(5000){
            rule.onAllNodesWithText(NAME).fetchSemanticsNodes().isEmpty()
        }
        rule.onNodeWithText(NAME).assertDoesNotExist()
    }
}