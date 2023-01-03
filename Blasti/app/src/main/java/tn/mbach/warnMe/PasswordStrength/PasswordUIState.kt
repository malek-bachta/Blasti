package tn.mbach.warnMe.PasswordStrength

import android.graphics.Color

data class PasswordUIState(
    val strength: PasswordStrength = PasswordStrength.UNMEASURED,
    val color: Int = Color.GRAY,
    val score: Int = 0,
    val progressScore : Int = score * 33
)