package kz.garage.multimedia.store.model

import android.net.Uri
import java.io.File
import kotlin.random.Random

/**
 * [id] - The unique ID of the [Content]
 * [uri] - The uri path of the [Content] (usually content://...)
 * [title] - The title of the [Content]
 * [displayName] - The display name of the [Content]. For example, an [Content] stored at
 * {@code /storage/0000-0000/DCIM/Vacation/IMG1024.JPG} would have a display name of {@code IMG1024.JPG}.
 * [folder] - The primary folder of this [Content]
 * [localFile] - The local duplicate file, which is generated by given [uri]
 */
open class Content constructor(
    open val id: Long,
    open val uri: Uri,
    open val title: String?,
    open val displayName: String?,
    open val folder: Folder?,
    open val history: History?,
    open val properties: Properties?,
    open val localFile: LocalFile?
) {

    companion object {
        fun generateId(): Long {
            return System.currentTimeMillis() + Random.nextLong()
        }
    }

    val label: String?
        get() = if (!title.isNullOrBlank()) {
            title
        } else if (!displayName.isNullOrBlank()) {
            displayName
        } else {
            null
        }

    data class LocalFile constructor(
        val uri: Uri
    ) {

        val file: File
            get() {
                require(uri.scheme == "file") { "Uri lacks 'file' scheme: $this" }
                return File(requireNotNull(uri.path) { "Uri path is null: $this" })
            }

    }

    /**
     * [addedAt] - The time the [Content] was first added (milliseconds)
     * [modifiedAt] - The time the [Content] was last modified (milliseconds)
     * [createdAt] - The time the [Content] was created. If image or video, it is as same as date taken (milliseconds)
     */
    data class History constructor(
        val addedAt: Long? = null,
        val modifiedAt: Long? = null,
        val createdAt: Long? = null,
    ) {

        fun isEmpty(): Boolean {
            return addedAt == null && modifiedAt == null && createdAt == null
        }
    }

    data class Properties constructor(
        val size: Long,
        val mimeType: String? = null,
    ) {

        companion object {
            const val UNDEFINED_SIZE = -1L
        }

        fun hasUndefinedSize(): Boolean {
            return size == UNDEFINED_SIZE
        }
    }

    override fun toString(): String {
        return "${Content::class.java.simpleName}(id=$id, uri=$uri, title=$title, displayName=$displayName, folder=$folder, history=$history, properties=$properties, localFile=$localFile)"
    }

}