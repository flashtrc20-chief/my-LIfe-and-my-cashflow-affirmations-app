package com.affirmations.app.data

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

data class AffirmationCollection(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val affirmations: List<Affirmation> = emptyList(),
    val releasedDate: Long = 0
)

data class Affirmation(
    val id: String = "",
    val title: String = "",
    val paragraphs: List<String> = emptyList(),
    val order: Int = 0
)

class FirebaseRepository {
    private val db = FirebaseFirestore.getInstance()

    suspend fun getCollections(): List<AffirmationCollection> {
        return try {
            val snapshot = db.collection("collections").get().await()
            snapshot.documents.mapNotNull { doc ->
                doc.toObject(AffirmationCollection::class.java)?.copy(id = doc.id)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    suspend fun getAffirmationsForToday(): Affirmation? {
        return try {
            val snapshot = db.collection("daily_affirmations")
                .document("today")
                .get()
                .await()
            snapshot.toObject(Affirmation::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun saveUserProgress(userId: String, collectionId: String, affirmationId: String) {
        try {
            db.collection("users")
                .document(userId)
                .collection("progress")
                .document(affirmationId)
                .set(mapOf(
                    "completed" to true,
                    "timestamp" to System.currentTimeMillis()
                ))
                .await()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
