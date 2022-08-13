package com.example.busschedule.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.busschedule.database.schedule.DAO
import com.example.busschedule.database.schedule.Schedule

class BusScheduleViewModel(private val scheduleDao: DAO.ScheduleDao) : ViewModel() {
    fun fullSchedule(): List<Schedule> = scheduleDao.getAll()
    fun scheduleForStopName(name: String): List<Schedule> = scheduleDao.getByStopName(name)
}

class BusScheduleViewModelFactory(
    private val scheduleDao: DAO.ScheduleDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BusScheduleViewModel::class.java)) {
            @Suppress("UNCHECKED CAST")
            return BusScheduleViewModel(scheduleDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
