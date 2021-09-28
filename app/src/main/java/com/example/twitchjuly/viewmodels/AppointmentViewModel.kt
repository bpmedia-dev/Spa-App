package com.example.twitchjuly.viewmodels

import androidx.lifecycle.ViewModel
import com.example.twitchjuly.model.AppointmentModel
import com.example.twitchjuly.model.TimeSlots
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class AppointmentViewModel : ViewModel()  {
    private val availableApts = listOf(
        AppointmentModel(
            serviceLocation = "Nashville",
            serviceAddress = "123 Broadway Ave, Nashville, TN 12345",
            serviceDate = "16.8.21",
            serviceTime = "6:30 CST",
            interval = TimeSlots.THIRTYMINUTES,
            isPast = true
        ),
        AppointmentModel(
            serviceLocation = "Nashville",
            serviceAddress = "123 Broadway Ave, Nashville, TN 12345",
            serviceDate = "18.8.21",
            serviceTime = "6:30 CST",
            interval = TimeSlots.THIRTYMINUTES,
            isPast = false
        ),
        AppointmentModel(
            serviceLocation = "Nashville",
            serviceAddress = "123 Broadway Ave, Nashville, TN 12345",
            serviceDate = "19.8.21",
            serviceTime = "6:30 CST",
            interval = TimeSlots.THIRTYMINUTES,
            isPast = false
        )
    )
    private val userApts = mutableListOf(
        AppointmentModel(
            serviceLocation = "Nashville",
            serviceAddress = "123 Broadway Ave, Nashville, TN 12345",
            serviceDate = "16.8.21",
            serviceTime = "6:30 CST",
            interval = TimeSlots.THIRTYMINUTES,
            isPast = true
        ),
        AppointmentModel(
            serviceLocation = "Nashville",
            serviceAddress = "123 Broadway Ave, Nashville, TN 12345",
            serviceDate = "19.8.21",
            serviceTime = "6:30 CST",
            interval = TimeSlots.THIRTYMINUTES,
            isPast = false
        ),
    )

    // TODO: pull details from server
    fun getAvailableAppointments() = availableApts

    // TODO: pull details from server
    fun getUserAppointments() = userApts

    // TODO: push details to server based on userId
    fun addUserAppointments(appointment: AppointmentModel) = userApts.add(appointment)
}