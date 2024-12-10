package com.example.processo_seletivo

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.processo_seletivo.ui.maps.MapScreen
import org.junit.Rule
import org.junit.Test

class MapTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun should_show_map() {
        rule.setContent {
            MapScreen()
        }
        rule.onNodeWithTag("Map").assertIsDisplayed()
    }
}

