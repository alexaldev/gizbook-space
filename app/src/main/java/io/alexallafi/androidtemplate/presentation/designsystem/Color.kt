package io.alexallafi.androidtemplate.presentation.designsystem

import androidx.compose.ui.graphics.Color

/**
 * Tonal palette built around the brand orange, gizmo_orange #FFA86A.
 *
 * In CIELAB the brand orange is L*76 / C52 / h60, which puts it exactly on tone 80 of a
 * Material 3 style ramp, so [Orange80] is the brand color verbatim. Every other tone is that
 * same hue held constant while lightness steps through the scale, chroma clamped to the sRGB
 * gamut. gizmo_dark #222129 is likewise the literal value of [Neutral13]: the neutral ramp
 * carries its faint violet cast (h296 / C5.8), which keeps the greys cool against the warm
 * accent instead of muddying it.
 *
 * Roles:
 *  - Orange: primary. Tone 40 for light surfaces, tone 80 (the brand color) for dark ones.
 *  - Sand: secondary. Same warm family, pulled toward tan so containers stay distinct.
 *  - Teal: tertiary. Complement of the orange, and the hue the old TealPrimary already used.
 *  - Neutral / NeutralVariant: surfaces, text and outlines.
 *  - Red: errors, the Material 3 baseline error ramp.
 *
 * Every foreground/background pair used in the two schemes in Theme.kt clears WCAG AA (4.5:1),
 * outlines clear the 3:1 non-text threshold.
 */

// Primary: brand orange.
val Orange0 = Color(0xFF030000)
val Orange10 = Color(0xFF2D1600)
val Orange20 = Color(0xFF502500)
val Orange30 = Color(0xFF733500)
val Orange40 = Color(0xFF924B0F)
val Orange50 = Color(0xFFB06429)
val Orange60 = Color(0xFFCE7D41)
val Orange70 = Color(0xFFEC975A)
val Orange80 = Color(0xFFFFA86A)
val Orange90 = Color(0xFFFFDCC6)
val Orange95 = Color(0xFFFEEEE3)
val Orange100 = Color(0xFFFFFFFF)

// Secondary: muted sand, for supporting surfaces and chips.
val Sand0 = Color(0xFF020000)
val Sand10 = Color(0xFF271900)
val Sand20 = Color(0xFF3E2D13)
val Sand30 = Color(0xFF564428)
val Sand40 = Color(0xFF705B3F)
val Sand50 = Color(0xFF8A7456)
val Sand60 = Color(0xFFA48D6E)
val Sand70 = Color(0xFFC0A788)
val Sand80 = Color(0xFFDCC3A2)
val Sand90 = Color(0xFFF9DEBD)
val Sand95 = Color(0xFFFFEEDA)
val Sand100 = Color(0xFFFFFFFF)

// Tertiary: teal, the orange's complement.
val Teal0 = Color(0xFF000100)
val Teal10 = Color(0xFF00211B)
val Teal20 = Color(0xFF003830)
val Teal30 = Color(0xFF005047)
val Teal40 = Color(0xFF006B5E)
val Teal50 = Color(0xFF1D8577)
val Teal60 = Color(0xFF3FA091)
val Teal70 = Color(0xFF5CBBAB)
val Teal80 = Color(0xFF78D7C6)
val Teal90 = Color(0xFF95F4E2)
val Teal95 = Color(0xFFB5FFF1)
val Teal100 = Color(0xFFFFFFFF)

// Neutrals: keyed to gizmo_dark, so Neutral13 is #222129 exactly.
val Neutral0 = Color(0xFF01000D)
val Neutral6 = Color(0xFF14121A)
val Neutral10 = Color(0xFF1C1B22)
val Neutral13 = Color(0xFF222129)
val Neutral17 = Color(0xFF2A2931)
val Neutral20 = Color(0xFF312F38)
val Neutral22 = Color(0xFF35343C)
val Neutral24 = Color(0xFF393841)
val Neutral30 = Color(0xFF47464F)
val Neutral40 = Color(0xFF5F5D67)
val Neutral50 = Color(0xFF777680)
val Neutral60 = Color(0xFF918F9A)
val Neutral70 = Color(0xFFABAAB4)
val Neutral80 = Color(0xFFC7C5D0)
val Neutral87 = Color(0xFFDAD9E4)
val Neutral90 = Color(0xFFE3E1EC)
val Neutral92 = Color(0xFFE8E7F2)
val Neutral94 = Color(0xFFEEEDF8)
val Neutral95 = Color(0xFFF1EFFB)
val Neutral96 = Color(0xFFF4F2FD)
val Neutral98 = Color(0xFFFAF9FF)
val Neutral100 = Color(0xFFFFFFFF)

// Neutral variant: same greys with a touch more chroma, for outlines and variant surfaces.
val NeutralVariant0 = Color(0xFF010013)
val NeutralVariant6 = Color(0xFF14121F)
val NeutralVariant10 = Color(0xFF1B1A28)
val NeutralVariant13 = Color(0xFF21202E)
val NeutralVariant17 = Color(0xFF2A2837)
val NeutralVariant20 = Color(0xFF302F3D)
val NeutralVariant22 = Color(0xFF353342)
val NeutralVariant24 = Color(0xFF393746)
val NeutralVariant30 = Color(0xFF474554)
val NeutralVariant40 = Color(0xFF5F5C6D)
val NeutralVariant50 = Color(0xFF777586)
val NeutralVariant60 = Color(0xFF918FA0)
val NeutralVariant70 = Color(0xFFACA9BB)
val NeutralVariant80 = Color(0xFFC7C4D7)
val NeutralVariant87 = Color(0xFFDBD8EB)
val NeutralVariant90 = Color(0xFFE3E0F3)
val NeutralVariant92 = Color(0xFFE9E6F9)
val NeutralVariant94 = Color(0xFFEEECFF)
val NeutralVariant95 = Color(0xFFF1EFFE)
val NeutralVariant96 = Color(0xFFF4F2FF)
val NeutralVariant98 = Color(0xFFF9F9FE)
val NeutralVariant100 = Color(0xFFFFFFFF)

// Error: Material 3 baseline error ramp.
val Red10 = Color(0xFF410E0B)
val Red20 = Color(0xFF601410)
val Red30 = Color(0xFF8C1D18)
val Red40 = Color(0xFFB3261E)
val Red80 = Color(0xFFF2B8B5)
val Red90 = Color(0xFFF9DEDC)

// Brand anchors, kept under their original names. Declared last: top-level properties are
// initialized in file order, so these have to follow the tones they alias.
val GizmoOrange = Orange80
val GizmoDark = Neutral13

